package vn.com.gsoft.socketio.service;

import org.springframework.kafka.support.SendResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface KafkaProducer {
    SendResult<String, String> sendInternal(String topic, String payload) throws InterruptedException, ExecutionException, TimeoutException;
}