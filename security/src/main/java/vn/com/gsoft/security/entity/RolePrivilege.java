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
@Table(name = RolePrivilege.TABLE_NAME)
public class RolePrivilege extends BaseEntity{
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ROLE_PRIVILEGE";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = RolePrivilege.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = RolePrivilege.TABLE_NAME + "_SEQ", allocationSize = 1, name = RolePrivilege.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Column(name = "PRIVILEGE_ID")
    private Long privilegeId;
}
