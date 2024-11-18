package vn.com.gsoft.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class LoadBalancedConfig {
    @Value("${rest.connectTimeout:30}")
    private Duration connectTimeout;
    @Value("${rest.readTimeout:30}")
    private Duration readTimeout;

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(connectTimeout == null ? Duration.ofSeconds(5) : connectTimeout)
                .setReadTimeout(readTimeout == null ? Duration.ofSeconds(5) : readTimeout)
                .build();
    }
}