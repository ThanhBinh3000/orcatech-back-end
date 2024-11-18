package vn.com.gsoft.config.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.config.entity.ServiceConfig;

import java.util.List;

@Repository
public interface ServiceConfigRepository extends CrudRepository<ServiceConfig, Long> {
    List<ServiceConfig> findByApplicationAndEnable(String application, Boolean enable);

    List<ServiceConfig> findByApplicationAndProfileInAndEnable(String application, List<String> profile, Boolean enable);

    List<ServiceConfig> findByApplicationAndProfileInAndLabelAndEnable(String application, List<String> profile, String label, Boolean enable);
}