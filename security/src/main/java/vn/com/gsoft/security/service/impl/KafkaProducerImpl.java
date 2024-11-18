package vn.com.gsoft.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.security.service.KafkaProducer;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaInternalTemplate;
    @Value("${kafka.send-timeout}")
    private long sendTimeout;

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 5000, multiplier = 2), value = {TimeoutException.class})
    public SendResult<String, String> sendInternal(String topic, String payload) throws InterruptedException, ExecutionException, TimeoutException {
        log.info("Sent Time: {}  - Sent topic: {} - payload: {}", new Date(), topic, payload);
        CompletableFuture<SendResult<String, String>> future = kafkaInternalTemplate.send(topic, payload);
        return future.get(sendTimeout, TimeUnit.SECONDS);
    }
}