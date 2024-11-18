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
@Table(name = CompanyEmployees.TABLE_NAME)
public class CompanyEmployees extends BaseEntity{
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "COMPANY_EMPLOYEES";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CompanyEmployees.TABLE_NAME + "_SEQ")
    @SequenceGenerator(sequenceName = CompanyEmployees.TABLE_NAME + "_SEQ", allocationSize = 1, name = CompanyEmployees.TABLE_NAME + "_SEQ")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "COMPANY_ID")
    private String companyId;
    @Column(name = "USER_USER_ID")
    private Long userUserId;
    @Column(name = "ARCHIVED_ID")
    private Long archivedId;
}
