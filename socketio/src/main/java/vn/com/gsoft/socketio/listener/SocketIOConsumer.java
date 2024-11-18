package vn.com.gsoft.socketio.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import vn.com.gsoft.socketio.service.LoginService;

@Service
@RefreshScope
@Slf4j
@RequiredArgsConstructor
public class SocketIOConsumer {
    @Autowired
    private LoginService loginService;

    @KafkaListener(topics = "#{'${kafka.internal.consumer.topic.login}'}", groupId = "#{'${kafka.internal.consumer.group-id}'}", containerFactory = "kafkaInternalListenerContainerFactory")
    public void receiveExternal(@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partitionId,
                                @Header(KafkaHeaders.OFFSET) Long offset,
                                @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long receivedTimestamp,
                                @Payload String payload) throws Exception {
        log.info("receivedTimestamp: {} - Received topic: {} - partition: {} - offset: {} - payload:{}", receivedTimestamp, topic, partitionId, offset, payload);
        // xử lý message
        loginService.sendMessageLogin(topic, partitionId, offset, receivedTimestamp, payload);
    }
}