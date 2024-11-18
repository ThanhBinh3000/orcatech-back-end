package vn.com.gsoft.security.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.com.gsoft.security.model.system.BaseRequest;

import java.util.Date;

@Data
public class UserProfileReq extends BaseRequest {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private Date birthDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date birthDateFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date birthDateTo;
    private Integer gender;
    private String email;
    private String phoneNumber;
    private String companyId;
    private Boolean isActive;
    private String citizenIdNumber;
    private Boolean enableNT;
    private Long regionId;
    private Long ProvinceId;
    private Long cityId;
    private Long wardId;
    private String addresses;
    private String zipCode;
    private Long entityId;
}
