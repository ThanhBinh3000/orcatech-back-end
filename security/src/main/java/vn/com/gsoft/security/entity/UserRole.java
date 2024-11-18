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
@Table(name = UserRole.TABLE_NAME)
public class UserRole extends BaseEntity{
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "USER_ROLE";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = UserRole.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = UserRole.TABLE_NAME + "_SEQ", allocationSize = 1, name = UserRole.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "ROLE_ID")
    private Long roleId;
}
