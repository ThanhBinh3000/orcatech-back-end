package vn.com.gsoft.categories.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class WebConfig {
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        return factory;
    }
}