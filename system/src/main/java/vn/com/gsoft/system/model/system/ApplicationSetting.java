package vn.com.gsoft.system.model.system;
import lombok.Data;

@Data
public class ApplicationSetting {
    private Long id;
    private String settingKey;
    private String settingValue;
    private String settingDisplayName;
    private Boolean isReadOnly;
    private String companyId;
    private String description;
    private Boolean activated;
    private Long roleId;
    private Long typeId;
}