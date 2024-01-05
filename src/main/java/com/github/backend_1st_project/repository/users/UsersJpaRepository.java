package com.github.backend_1st_project.repository.users;

import com.github.backend_1st_project.web.dto.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersJpaRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findByUserId(String userId);
}
