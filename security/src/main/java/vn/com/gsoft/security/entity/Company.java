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
@Table(name = Company.TABLE_NAME)
public class Company extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "COMPANY";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Company.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Company.TABLE_NAME + "_SEQ", allocationSize = 1, name = Company.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "COMPANY_ID")
    private String companyId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "REGION_ID")
    private Long regionId;
    @Column(name = "CITY_ID")
    private Long cityId;
    @Column(name = "WARD_ID")
    private Long wardId;
    @Column(name = "ADDRESSES")
    private String addresses;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;
    @Column(name = "COMPANY_WEBSITE")
    private String companyWebsite;
    @Column(name = "TAX_IDENTIFICATION_NUMBER")
    private String taxIdentificationNumber;
    @Column(name = "IMAGE_ORDER_THUMBURL")
    private String imageOrderThumbUrl;
    @Column(name = "IMAGE_ORDER_PREVIEWURL")
    private String imageOrderPreviewUrl;

    @Transient
    private String role;
}