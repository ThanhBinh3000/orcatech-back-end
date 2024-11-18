package vn.com.gsoft.socketio.listener;

import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SocketIOListener {
    @Autowired
    private SocketIOServer server;

    @PostConstruct
    public void startServer() {
        this.server.start();
        int socketIOPort = server.getConfiguration().getPort(); // Lấy cổng ngẫu nhiên sau khi server khởi động
        log.info("SocketIO server started at port: " + socketIOPort);
        this.server.addConnectListener(client -> {
            log.info("Client connected: " + client.getSessionId());
        });
        this.server.addDisconnectListener(client -> {
            log.info("Client disconnected: " + client.getSessionId());
        });
    }

    @PreDestroy
    public void stopServer() {
        server.stop();
    }
}