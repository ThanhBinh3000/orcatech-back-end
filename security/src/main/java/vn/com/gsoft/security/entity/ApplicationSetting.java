package vn.com.gsoft.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ApplicationSetting.TABLE_NAME)
public class ApplicationSetting {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "APPLICATION_SETTING";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ApplicationSetting.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = ApplicationSetting.TABLE_NAME + "_SEQ", allocationSize = 1, name = ApplicationSetting.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SETTING_KEY")
    private String settingKey;
    @Column(name = "SETTING_VALUE")
    private String settingValue;
    @Column(name = "SETTING_DISPLAY_NAME")
    private String settingDisplayName;
    @Column(name = "IS_READ_ONLY")
    private Boolean isReadOnly;
    @Column(name = "COMPANY_ID")
    private String companyId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVATED")
    private Boolean activated;
    @Column(name = "RELE_ID")
    private Long roleId;
    @Column(name = "TYPE_ID")
    private Long typeId;
}