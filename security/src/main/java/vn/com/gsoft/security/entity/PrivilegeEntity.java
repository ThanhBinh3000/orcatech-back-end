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
@Table(name = PrivilegeEntity.TABLE_NAME)
public class PrivilegeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "PRIVILEGE_ENTITY";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PrivilegeEntity.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = PrivilegeEntity.TABLE_NAME + "_SEQ", allocationSize = 1, name = PrivilegeEntity.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRIVILEGE_ID")
    private Long privilegeId;
    @Column(name = "ENTITY_ID")
    private Long entityId;
}
