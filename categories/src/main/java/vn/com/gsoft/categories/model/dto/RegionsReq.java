package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class RegionsReq extends BaseRequest {
    private Long id;
    private String name;
    private String code;
}
