package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Cities;
import vn.com.gsoft.categories.entity.Provinces;
import vn.com.gsoft.categories.model.dto.CitiesReq;

import java.util.List;

@Repository
public interface CitiesRepository extends BaseRepository<Cities, CitiesReq, Long> {
    @Query("SELECT c FROM Cities c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.provinceId} IS NULL OR c.provinceId = :#{#param.provinceId}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    Page<Cities> searchPage(@Param("param") CitiesReq param, Pageable pageable);

    @Query("SELECT c FROM Cities c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.provinceId} IS NULL OR c.provinceId = :#{#param.provinceId}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    List<Cities> searchList(@Param("param") CitiesReq param);

    List<Cities> findByProvinceIdAndRecordStatusId(Long provinceId, Long recordStatusId);
}
