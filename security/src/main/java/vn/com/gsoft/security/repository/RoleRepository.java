package vn.com.gsoft.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.security.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "select r from Role r " +
            "join UserRole ur on ur.roleId = r.id  " +
            "where ur.userId = ?1 and (r.isDefault = true or r.companyId = ?2)")
    List<Role> findByUserIdAndCompanyId(Long userId, String companyId);

    @Query(value = "SELECT r from Role r " +
            "join UserRole ur on ur.roleId = r.id  " +
            "join RoleType rt on rt.id = r.roleTypeId  " +
            "where (rt.roleName = 'SuperUser' OR rt.roleName = 'TechnicalSupport') and ur.userId = ?1")
    List<Role> findByUserId(Long id);
}