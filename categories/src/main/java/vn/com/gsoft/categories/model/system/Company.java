package vn.com.gsoft.categories.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long id;
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
    private Date created;
    private Long createdByUserId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date modified;
    private Long modifiedByUserId;
    private Long recordStatusId;
}