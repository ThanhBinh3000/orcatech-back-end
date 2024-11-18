package vn.com.gsoft.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.security.entity.RoleType;

@Repository
public interface RoleTypeRepository extends JpaRepository<RoleType, Long> {
}
