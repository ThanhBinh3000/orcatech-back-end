package vn.com.gsoft.system.service.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.system.entity.Process;
import vn.com.gsoft.system.entity.ProcessDtl;
import vn.com.gsoft.system.model.system.WrapData;
import vn.com.gsoft.system.repository.ProcessDtlRepository;
import vn.com.gsoft.system.repository.ProcessRepository;
import vn.com.gsoft.system.service.KafkaProducer;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class KafkaProducerImpl implements KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaInternalTemplate;
    @Value("${kafka.send-timeout}")
    private long sendTimeout;
    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private ProcessDtlRepository processDtlRepository;

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 5000, multiplier = 2), value = {TimeoutException.class})
    public SendResult<String, String> sendInternal(String topic, String payload) throws InterruptedException, ExecutionException, TimeoutException {
        log.info("Sent Time: {}  - Sent topic: {} - payload: {}", new Date(), topic, payload);
        CompletableFuture<SendResult<String, String>> future = kafkaInternalTemplate.send(topic, payload);
        return future.get(sendTimeout, TimeUnit.SECONDS);
    }

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 5000, multiplier = 2), value = {TimeoutException.class})
    public SendResult<String, String> sendInternal(String topic, String key, String payload) throws InterruptedException, ExecutionException, TimeoutException {
        log.info("Sent Time: {}  - Sent topic: {}  Sent key: {} - payload: {}", new Date(), topic, key, payload);
        CompletableFuture<SendResult<String, String>> future = kafkaInternalTemplate.send(topic, key, payload);
        return future.get(sendTimeout, TimeUnit.SECONDS);
    }

    @Override
    public Process createProcess(String batchKey, String companyId, String json, Date date, int size, Long userId) throws Exception {
        // check batchKey
        Optional<Process> checkOpt = processRepository.findByBatchKey(batchKey);
        if (checkOpt.isPresent())
            throw new Exception("Duplicate batchKey error!");
        Process process = new Process();
        process.setBatchKey(batchKey);
        process.setCompanyId(companyId);
        process.setStartDate(date);
        process.setTotal(size);
        process.setStatus(0); // 0: khởi tạo, 1: running , 2:done
        process.setCreateBy(userId);
        return processRepository.save(process);
    }

    @Override
    public ProcessDtl createProcessDtl(Process process, WrapData data) {
        ProcessDtl processDtl = new ProcessDtl();
        processDtl.setProcessId(process.getId());
        processDtl.setIndex(data.getIndex());
        processDtl.setData(new Gson().toJson(data));
        processDtl.setStartDate(new Date());
        processDtl.setStatus(0); // 0: khởi tạo, 1: running , 2:done
        return processDtlRepository.save(processDtl);
    }
}
