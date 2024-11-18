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
@Table(name = Privilege.TABLE_NAME)
public class Privilege extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PRIVILEGE";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Privilege.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Privilege.TABLE_NAME + "_SEQ", allocationSize = 1, name = Privilege.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "PARENT_CODE")
    private String parentCode;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ENABLE")
    private Boolean enable;
}
