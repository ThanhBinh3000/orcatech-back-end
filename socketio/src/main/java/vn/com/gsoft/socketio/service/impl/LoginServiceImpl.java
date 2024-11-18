package vn.com.gsoft.socketio.service.impl;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.socketio.service.LoginService;
import vn.com.gsoft.socketio.system.MessageDTO;

import java.util.UUID;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SocketIOServer server;

    @Override
    public void sendMessageLogin(String topic, Integer partitionId, Long offset, Long receivedTimestamp, String payload) throws Exception {
        // save data nhận
        // to do
        // xử lý login qr
        Gson gson = new Gson();
        MessageDTO data = gson.fromJson(payload, MessageDTO.class);
        log.info("Send event {} to {} ", "login-qr", data.getUuid());
        SocketIOClient client = server.getClient(UUID.fromString(data.getUuid()));
        if (client == null) {
            log.error("Not found client {}", data.getUuid());
            throw new Exception("Not found client");
        }
        client.sendEvent("login-qr", new AckCallback<>(String.class) {
            @Override
            public void onSuccess(String result) {
                log.info("Ack event {} from client {} - message: {}", "login-qr", data.getUuid(), result);
            }
        }, payload);
    }
}