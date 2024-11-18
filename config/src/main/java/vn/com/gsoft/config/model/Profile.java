package vn.com.gsoft.config.model;

import lombok.Data;

import java.util.List;

@Data
public class Profile {
    private String name;
    private List<String> profiles;
    private String label;
    private String version;
    private String state;
    private List<ProfileSource> propertySources;
}
