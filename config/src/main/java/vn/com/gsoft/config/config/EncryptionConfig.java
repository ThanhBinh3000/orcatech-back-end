package vn.com.gsoft.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class EncryptionConfig {
    @Value("${org.springframework.boot.env.secretKey}")
    private String secretKey;

    @Bean
    public Cipher decryptCipher() throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher;
    }
}
