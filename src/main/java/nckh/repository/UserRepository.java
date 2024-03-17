package nckh.repository;

import nckh.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByStatus(Integer status, Pageable page);

    UserEntity findOneByUserNameAndStatus(String name, int status);

    UserEntity findByUserName(String userName);

    UserEntity findByEmail(String email);

    @Query(value = "SELECT count(*) from user where status = :status", nativeQuery = true)
    int countUserByStatus(@Param(value = "status") Integer status);

    List<UserEntity> findUserEntityByStatus(Integer status);

}
