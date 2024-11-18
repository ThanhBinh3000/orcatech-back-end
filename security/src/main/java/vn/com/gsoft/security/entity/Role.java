package vn.com.gsoft.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ROLE";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Role.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = Role.TABLE_NAME + "_SEQ", allocationSize = 1, name = Role.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    @Column(name = "COMPANY_ID")
    private String companyId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ROLE_TYPE_ID")
    private Long roleTypeId;
    @Column(name = "IS_DEFAULT")
    private Boolean isDefault;  // true là mặc định
    @Transient
    private String roleType;
}

