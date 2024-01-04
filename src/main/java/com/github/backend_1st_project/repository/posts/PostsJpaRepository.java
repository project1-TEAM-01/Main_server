package com.github.backend_1st_project.repository.posts;

import com.github.backend_1st_project.web.dto.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsJpaRepository extends JpaRepository<PostEntity, Integer> {

    List<PostEntity> findByUserId(String userId);
}
