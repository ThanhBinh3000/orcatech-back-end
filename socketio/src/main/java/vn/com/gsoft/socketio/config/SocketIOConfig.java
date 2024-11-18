package vn.com.gsoft.socketio.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@org.springframework.context.annotation.Configuration
public class SocketIOConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;
    @Value("${redis.username}")
    private String username;
    @Value("${redis.password}")
    private String password;
    @Value("${port.range:30000,30999}")
    private Integer[] portRange;
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    @ConditionalOnMissingBean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean(SocketIOServer socketIOServer) {
        InetUtilsProperties properties = new InetUtilsProperties();
        InetUtils inetUtils = new InetUtils(properties);
        EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(inetUtils);
//        String port = System.getProperty("server.port");
        instance.setNonSecurePort(socketIOServer.getConfiguration().getPort());
        // Đặt trạng thái ban đầu của instance UP
        instance.setInitialStatus(InstanceInfo.InstanceStatus.UP);
        instance.setInstanceId(String.format("%s:%s:%d", getHostname(), applicationName, socketIOServer.getConfiguration().getPort()));
        // Cài đặt thêm các cấu hình khác nếu cần
        instance.setPreferIpAddress(true);
        Map<String, String> meta = new HashMap<>();
        meta.put("socketio-port", "" + socketIOServer.getConfiguration().getPort());
        instance.setMetadataMap(meta);
        return instance;
    }

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname("0.0.0.0");
        int port = findRandomOpenPort(portRange[0], portRange[1]);
        config.setPort(port);
        // Cấu hình Redis cho HA và session management
//        Config.setStoreFactory(new RedissonStoreFactory(redissonClient()));
        return new SocketIOServer(config);
    }

//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://" + host + ":" + port)
//                .setUsername(username)
//                .setPassword(password);
//        return Redisson.create(config);
//    }

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

    private String getHostname() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostName();
        } catch (Exception e) {
            e.printStackTrace();
            return "unknown-host";
        }
    }
}