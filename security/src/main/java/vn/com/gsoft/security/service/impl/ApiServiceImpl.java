package vn.com.gsoft.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.com.gsoft.security.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${url.login}")
    private String url;

    @Override
    public String confirmLogin(String username, String password) {
        // Tạo headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        // Tạo body
        String body = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);
        // Tạo request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        // Gọi API
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        // Trả về kết quả
        return response.getBody();
    }
}