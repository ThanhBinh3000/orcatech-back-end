package vn.com.gsoft.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.security.entity.Role;
import vn.com.gsoft.security.entity.RoleType;
import vn.com.gsoft.security.repository.RoleRepository;
import vn.com.gsoft.security.repository.RoleTypeRepository;
import vn.com.gsoft.security.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleTypeRepository roleTypeRepository;

    @Override
    public List<Role> findByUserIdAndCompanyId(Long id, String companyId) {
        List<Role> roles = roleRepository.findByUserIdAndCompanyId(id, companyId);
        for (Role r : roles) {
            Optional<RoleType> roleId = roleTypeRepository.findById(r.getId());
            roleId.ifPresent(roleType -> r.setRoleType(roleType.getDescripition()));
        }
        return roles;
    }

    @Override
    public List<Role> findByUserId(Long id) {
        List<Role> roles = roleRepository.findByUserId(id);
        for (Role r : roles) {
            Optional<RoleType> roleId = roleTypeRepository.findById(r.getRoleTypeId());
            roleId.ifPresent(roleType -> r.setRoleType(roleType.getDescripition()));
        }
        return roles;
    }
}