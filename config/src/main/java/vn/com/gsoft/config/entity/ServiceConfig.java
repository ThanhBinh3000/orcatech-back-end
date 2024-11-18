package vn.com.gsoft.config.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = ServiceConfig.TABLE_NAME)
public class ServiceConfig {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SERVICE_CONFIG";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ServiceConfig.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = ServiceConfig.TABLE_NAME + "_SEQ", allocationSize = 1, name = ServiceConfig.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "APPLICATION")
    private String application;
    @Column(name = "PROFILE")
    private String profile;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "KEYCONFIG")
    private String key;
    @Column(name = "VALUE")
    private String value;
    @Column(name = "ENABLE")
    private Boolean enable;
}
