package vn.com.gsoft.security.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.com.gsoft.security.model.system.BaseRequest;

import java.util.Date;

@Data
public class CompanyReq extends BaseRequest {
    private String companyId;
    private String companyName;
    private Long regionId;
    private Long cityId;
    private Long wardId;
    private String addresses;
    private String phoneNumber;
    private String companyEmail;
    private String companyWebsite;
    private String taxIdentificationNumber;
    private String imageOrderThumbUrl;
    private String imageOrderPreviewUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date fromDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date toDate;
}
