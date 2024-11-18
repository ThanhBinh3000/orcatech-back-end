package vn.com.gsoft.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = UserProfile.TABLE_NAME)
public class UserProfile extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "USER_PROFILE";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = UserProfile.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = UserProfile.TABLE_NAME + "_SEQ", allocationSize = 1, name = UserProfile.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWROD")
    private String password;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "GENDER")
    private Integer gender; // 1 Nam, 2 Nữ, 3 Khác
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "COMPANY_ID")
    private String companyId;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @Column(name = "CITIZED_ID_NUMBER")
    private String citizenIdNumber;
    @Column(name = "ENABLE_NT")
    private Boolean enableNT;
    @Column(name = "REGION_ID")
    private Long regionId;
    @Column(name = "PROVINCE_ID")
    private Long provinceId;
    @Column(name = "CITY_ID")
    private Long cityId;
    @Column(name = "WARD_ID")
    private Long wardId;
    @Column(name = "ADDRESSEA")
    private String addresses;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "ENTITY_ID")
    private Long entityId;
}
