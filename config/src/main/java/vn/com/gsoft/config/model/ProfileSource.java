package vn.com.gsoft.config.model;

import lombok.Data;

import java.util.Map;

@Data
public class ProfileSource {
    private String name;
    private Map<String, String> source;
}