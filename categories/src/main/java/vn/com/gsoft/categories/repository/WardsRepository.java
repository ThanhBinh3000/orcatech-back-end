package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Cities;
import vn.com.gsoft.categories.entity.Wards;
import vn.com.gsoft.categories.model.dto.WardsReq;

import java.util.List;

@Repository
public interface WardsRepository extends BaseRepository<Wards, WardsReq, Long> {
    @Query("SELECT c FROM Wards c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.citiesId} IS NULL OR c.citiesId = :#{#param.citiesId}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    Page<Wards> searchPage(@Param("param") WardsReq param, Pageable pageable);

    @Query("SELECT c FROM Wards c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.citiesId} IS NULL OR c.citiesId = :#{#param.citiesId}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    List<Wards> searchList(@Param("param") WardsReq param);

    List<Wards> findByCitiesIdAndRecordStatusId(Long citiesId, Long recordStatusId);
}