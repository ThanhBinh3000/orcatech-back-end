package vn.com.gsoft.security.service;

import vn.com.gsoft.security.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findByUserIdAndCompanyId(Long id, String companyId);

    List<Role> findByUserId(Long id);
}