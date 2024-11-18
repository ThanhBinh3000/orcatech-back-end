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
@Table(name = Settings.TABLE_NAME)
public class Settings {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SETTINGS";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Settings.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Settings.TABLE_NAME + "_SEQ", allocationSize = 1, name = Settings.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "KEY")
    private String key;
    @Column(name = "VALUE")
    private String value;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @Column(name = "COMPANY_ID")
    private String companyId;
}

