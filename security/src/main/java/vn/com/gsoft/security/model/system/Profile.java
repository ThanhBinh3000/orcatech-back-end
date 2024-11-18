package vn.com.gsoft.security.model.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import vn.com.gsoft.security.entity.ApplicationSetting;
import vn.com.gsoft.security.entity.Company;
import vn.com.gsoft.security.entity.Role;
import vn.com.gsoft.security.entity.Settings;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Profile implements UserDetails, Serializable {
    private static final long serialVersionUID = 620L;
    private static final Log logger = LogFactory.getLog(Profile.class);
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String fullName;
    private boolean enabled;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private Company company;
    private List<Role> roles;
    private List<Company> companys;
    private List<Settings> settings;
    private Set<CodeGrantedAuthority> authorities;
    private List<ApplicationSetting> applicationSettings;

    public Profile(Long id,
                   String username,
                   String password,
                   String fullName,
                   boolean enabled,
                   boolean accountNonLocked,
                   boolean accountNonExpired,
                   boolean credentialsNonExpired,
                   Company company,
                   List<Role> roles,
                   List<Company> companys,
                   List<Settings> settings,
                   Set<CodeGrantedAuthority> authorities,
                   List<ApplicationSetting> applicationSettings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.enabled = enabled;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.company = company;
        this.roles = roles;
        this.companys = companys;
        this.settings = settings;
        this.authorities = authorities;
        this.applicationSettings = applicationSettings;
    }
}