package vn.com.gsoft.system.model.system;

import lombok.Data;

import java.util.Date;

@Data
public class WrapData<T> {
    private String code;
    private Date sendDate;
    private T data;
    private String batchKey;
    private Integer index;
    private Integer total;
    private Profile profile;
}