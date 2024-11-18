package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Provinces;
import vn.com.gsoft.categories.model.dto.ProvincesReq;

import java.util.List;

@Repository
public interface ProvincesRepository extends BaseRepository<Provinces, ProvincesReq, Long> {

    @Query("SELECT c FROM Provinces c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.regionId} IS NULL OR c.regionId = :#{#param.regionId}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    Page<Provinces> searchPage(@Param("param") ProvincesReq param, Pageable pageable);

    @Query("SELECT c FROM Provinces c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.regionId} IS NULL OR c.regionId = :#{#param.regionId}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    List<Provinces> searchList(@Param("param") ProvincesReq param);

    List<Provinces> findByRegionIdAndRecordStatusId(Long regionId, Long recordStatusId);
}
