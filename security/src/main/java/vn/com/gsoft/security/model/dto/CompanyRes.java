package vn.com.gsoft.security.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyRes {
    private Long id;
    private String companyId;
    private String companyName;
    private String personInCharge;
    private String role;

    public CompanyRes(Long id, String companyId, String companyName, String personInCharge, String role) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.personInCharge = personInCharge;
        this.role = role;
    }
}