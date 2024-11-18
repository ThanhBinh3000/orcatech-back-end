package vn.com.gsoft.security.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.security.constant.RecordStatusContains;
import vn.com.gsoft.security.entity.Company;
import vn.com.gsoft.security.model.dto.CompanyReq;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByCompanyId(String companyId);

    @Query(value = "select p from Company p " +
            "join CompanyEmployees nv on nv.companyId = p.companyId " +
            "where nv.recordStatusId =  " + RecordStatusContains.ACTIVE +
            " and nv.userUserId =?1  ")
    List<Company> findByUserId(Long userId);

    @Query("select c.id as id, c.companyId as companyId, c.companyName as companyName, nv.role as role, " +
            "(select ua.fullName from UserProfile ua join CompanyEmployees nva on nva.userUserId = ua.id " +
            "where nva.role = 'Admin' and nva.companyId = c.companyId) as personInCharge " +
            "from Company c " +
            "join CompanyEmployees nv on c.companyId = nv.companyId " +
            "join UserProfile u on nv.userUserId = u.id " +
            "where 1=1 and u.id = :#{#param.userIdQueryData} " +
            "and lower(c.companyId) like lower(:#{param.companyId}) " +
            "order by c.id desc ")
    Tuple getUserRoleCompany(@Param("param") CompanyReq req);
}