package vn.com.gsoft.categories.model.system;

import lombok.Data;

@Data
public class Settings {
    private Long id;
    private String key;
    private String value;
    private Boolean isActive;
    private String companyId;
}

