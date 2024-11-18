package vn.com.gsoft.socketio.service;

public interface LoginService {
    void sendMessageLogin(String topic, Integer partitionId, Long offset, Long receivedTimestamp, String payload) throws Exception;
}