package vn.com.gsoft.categories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.ProcessDtl;

@Repository
public interface ProcessDtlRepository extends JpaRepository<ProcessDtl, Long> {
}
