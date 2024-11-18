package vn.com.gsoft.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.system.entity.Process;

import java.util.Optional;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    Optional<Process> findByBatchKey(String batchKey);
}
