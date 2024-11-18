package vn.com.gsoft.system.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.system.entity.UserProfile;
import vn.com.gsoft.system.model.dto.UserProfileReq;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends BaseRepository<UserProfile, UserProfileReq, Long> {
    @Query("SELECT c FROM UserProfile c " +
            " WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.username} IS NULL OR lower(c.username) LIKE lower(concat('%',CONCAT(:#{#param.username},'%'))))"
            + " AND (:#{#param.password} IS NULL OR lower(c.password) LIKE lower(concat('%',CONCAT(:#{#param.password},'%'))))"
            + " AND (:#{#param.fullName} IS NULL OR lower(c.fullName) LIKE lower(concat('%',CONCAT(:#{#param.fullName},'%'))))"
            + " AND (:#{#param.birthDate} IS NULL OR c.birthDate >= :#{#param.birthDateFrom}) "
            + " AND (:#{#param.birthDate} IS NULL OR c.birthDate <= :#{#param.birthDateTo}) "
            + " AND (:#{#param.email} IS NULL OR lower(c.email) LIKE lower(concat('%',CONCAT(:#{#param.email},'%'))))"
            + " AND (:#{#param.phoneNumber} IS NULL OR lower(c.phoneNumber) LIKE lower(concat('%',CONCAT(:#{#param.phoneNumber},'%'))))"
            + " AND (:#{#param.companyId} IS NULL OR lower(c.companyId) LIKE lower(concat('%',CONCAT(:#{#param.companyId},'%'))))"
            + " AND (:#{#param.isActive} IS NULL OR c.isActive = :#{#param.isActive}) "
            + " AND (:#{#param.citizenIdNumber} IS NULL OR lower(c.citizenIdNumber) LIKE lower(concat('%',CONCAT(:#{#param.citizenIdNumber},'%'))))"
            + " AND (:#{#param.enableNT} IS NULL OR c.enableNT = :#{#param.enableNT}) "
            + " AND (:#{#param.regionId} IS NULL OR c.regionId = :#{#param.regionId}) "
            + " AND (:#{#param.cityId} IS NULL OR c.cityId = :#{#param.cityId}) "
            + " AND (:#{#param.wardId} IS NULL OR c.wardId = :#{#param.wardId}) "
            + " AND (:#{#param.addresses} IS NULL OR lower(c.addresses) LIKE lower(concat('%',CONCAT(:#{#param.addresses},'%'))))"
            + " AND (:#{#param.entityId} IS NULL OR c.entityId = :#{#param.entityId}) "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId})"
            + " AND (:#{#param.recordStatusIds} IS NULL OR c.recordStatusId in :#{#param.recordStatusIds}) "
            + " ORDER BY c.id desc")
    Page<UserProfile> searchPage(@Param("param") UserProfileReq param, Pageable pageable);

    @Query("SELECT c FROM UserProfile c " +
            " WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.username} IS NULL OR lower(c.username) LIKE lower(concat('%',CONCAT(:#{#param.username},'%'))))"
            + " AND (:#{#param.password} IS NULL OR lower(c.password) LIKE lower(concat('%',CONCAT(:#{#param.password},'%'))))"
            + " AND (:#{#param.fullName} IS NULL OR lower(c.fullName) LIKE lower(concat('%',CONCAT(:#{#param.fullName},'%'))))"
            + " AND (:#{#param.birthDate} IS NULL OR c.birthDate >= :#{#param.birthDateFrom}) "
            + " AND (:#{#param.birthDate} IS NULL OR c.birthDate <= :#{#param.birthDateTo}) "
            + " AND (:#{#param.email} IS NULL OR lower(c.email) LIKE lower(concat('%',CONCAT(:#{#param.email},'%'))))"
            + " AND (:#{#param.phoneNumber} IS NULL OR lower(c.phoneNumber) LIKE lower(concat('%',CONCAT(:#{#param.phoneNumber},'%'))))"
            + " AND (:#{#param.companyId} IS NULL OR lower(c.companyId) LIKE lower(concat('%',CONCAT(:#{#param.companyId},'%'))))"
            + " AND (:#{#param.isActive} IS NULL OR c.isActive = :#{#param.isActive}) "
            + " AND (:#{#param.citizenIdNumber} IS NULL OR lower(c.citizenIdNumber) LIKE lower(concat('%',CONCAT(:#{#param.citizenIdNumber},'%'))))"
            + " AND (:#{#param.enableNT} IS NULL OR c.enableNT = :#{#param.enableNT}) "
            + " AND (:#{#param.regionId} IS NULL OR c.regionId = :#{#param.regionId}) "
            + " AND (:#{#param.cityId} IS NULL OR c.cityId = :#{#param.cityId}) "
            + " AND (:#{#param.wardId} IS NULL OR c.wardId = :#{#param.wardId}) "
            + " AND (:#{#param.addresses} IS NULL OR lower(c.addresses) LIKE lower(concat('%',CONCAT(:#{#param.addresses},'%'))))"
            + " AND (:#{#param.entityId} IS NULL OR c.entityId = :#{#param.entityId}) "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId})"
            + " AND (:#{#param.recordStatusIds} IS NULL OR c.recordStatusId in :#{#param.recordStatusIds}) "
            + " ORDER BY c.id desc")
    List<UserProfile> searchList(@Param("param") UserProfileReq param);

    Optional<UserProfile> findByUsername(String username);
}
