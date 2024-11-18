package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class CitiesReq extends BaseRequest {
    private Long id;
    private Long provinceId;
    private String name;
    private String code;
}
