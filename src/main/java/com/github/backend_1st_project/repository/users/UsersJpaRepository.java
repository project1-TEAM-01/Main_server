package com.github.backend_1st_project.repository.users;

import com.github.backend_1st_project.web.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersJpaRepository extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT c FROM UserEntity c WHERE c.userEmail = :userEmail")
    List<UserEntity> findByEmail(String userEmail);
    UserEntity findByUserEmail(String userEmail);

    @Query("SELECT c FROM UserEntity c WHERE c.userEmail = :userEmail")
    UserEntity findByUserEquals(String userEmail);
}
