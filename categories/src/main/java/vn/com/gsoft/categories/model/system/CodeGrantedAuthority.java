package vn.com.gsoft.categories.model.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGrantedAuthority implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 620L;
    private String authority;

    public String getAuthority() {
        return this.authority;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof CodeGrantedAuthority) {
            CodeGrantedAuthority sga = (CodeGrantedAuthority) obj;
            return this.authority.equals(sga.getAuthority());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.authority.hashCode();
    }

    public String toString() {
        return this.authority;
    }
}
