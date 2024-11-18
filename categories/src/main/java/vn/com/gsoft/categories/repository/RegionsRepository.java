package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Regions;
import vn.com.gsoft.categories.model.dto.RegionsReq;

import java.util.List;

@Repository
public interface RegionsRepository extends BaseRepository<Regions, RegionsReq, Long> {
    @Query("SELECT c FROM Regions c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    Page<Regions> searchPage(@Param("param") RegionsReq param, Pageable pageable);

    @Query("SELECT c FROM Regions c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
            + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.name ASC ")
    List<Regions> searchList(@Param("param") RegionsReq param);
}
