package vn.com.gsoft.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.security.entity.Settings;

import java.util.List;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
    @Query("SELECT c FROM Settings c WHERE c.companyId = ?1")
    List<Settings> findByCompanyId(String companyId);
}
