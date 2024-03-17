package nckh.repository;

import nckh.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author ADMIN
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
  RoleEntity findOneByCode (String Code);
}
