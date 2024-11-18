package vn.com.gsoft.security.model.dto;

import lombok.Data;

@Data
public class CheckLogin {
    private Integer status;
    private String[] errors;
    private Boolean data;
}
