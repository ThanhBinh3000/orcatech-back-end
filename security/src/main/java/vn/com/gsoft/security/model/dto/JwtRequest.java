package vn.com.gsoft.security.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
