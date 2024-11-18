package vn.com.gsoft.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.security.entity.Privilege;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    @Query(value = "select p from Privilege p " +
            "join PrivilegeEntity pe on pe.privilegeId = p.id " +
            "join RolePrivilege rp on rp.privilegeId = p.id " +
            "join Role r on r.id = rp.roleId " +
            "where p.enable = true and r.isDeleted = false and r.id in ?1 and (r.isDefault = true or r.companyId = ?2) and pe.entityId = ?3")
    List<Privilege> findByRoleIdInAndCompanyIdAndEntityId(List<Long> roleIds, String companyId, Long entityId);

    @Query(value = "select p from Privilege p " +
            "join PrivilegeEntity pe on pe.privilegeId = p.id " +
            "join RolePrivilege rp on rp.privilegeId = p.id " +
            "join Role r on r.id = rp.roleId " +
            "where p.enable = true and r.isDeleted = false and r.id in ?1")
    List<Privilege> findByRoleIdInAndEntityId(List<Long> roleIds);
}