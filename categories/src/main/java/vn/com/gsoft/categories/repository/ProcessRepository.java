package vn.com.gsoft.categories.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Process;

import java.util.Optional;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    Optional<Process> findByBatchKey(String batchKey);
}
