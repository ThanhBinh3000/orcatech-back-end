package vn.com.gsoft.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.system.entity.ProcessDtl;

@Repository
public interface ProcessDtlRepository extends JpaRepository<ProcessDtl, Long> {
}
