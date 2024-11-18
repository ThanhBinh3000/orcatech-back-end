package vn.com.gsoft.security.model.dto;

import lombok.Data;

@Data
public class JwtResponse {
    private final String token;
    private final String refreshToken;
}
