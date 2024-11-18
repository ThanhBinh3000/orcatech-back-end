package vn.com.gsoft.socketio.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

@Component
@Slf4j
public class PortCustomizerConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Value("${port.range:30000,30999}")
    private Integer[] portRange;

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        int port = findRandomOpenPort(portRange[0], portRange[1]);
        factory.setPort(port);
        System.setProperty("server.port", String.valueOf(port));
    }

    private int findRandomOpenPort(int min, int max) {
        Random random = new Random();
        int portRange = max - min + 1;
        int port = min + random.nextInt(portRange);
        while (!isPortAvailable(port)) {
            port = min + random.nextInt(portRange);
        }
        return port;
    }

    private boolean isPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}