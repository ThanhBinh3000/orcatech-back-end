package vn.com.gsoft.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        return factory;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}