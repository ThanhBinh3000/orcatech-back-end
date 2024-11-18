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
@Table(name = RoleType.TABLE_NAME)
public class RoleType extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ROLE_TYPE";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = RoleType.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = RoleType.TABLE_NAME + "_SEQ", allocationSize = 1, name = RoleType.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "DESCRIPITION")
    private String descripition;
}