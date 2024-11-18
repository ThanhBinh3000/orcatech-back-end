package vn.com.gsoft.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.security.entity.ApplicationSetting;

import java.util.List;

@Repository
public interface ApplicationSettingRepository extends JpaRepository<ApplicationSetting, Long> {
    List<ApplicationSetting> findByCompanyId(String companyId);
}
