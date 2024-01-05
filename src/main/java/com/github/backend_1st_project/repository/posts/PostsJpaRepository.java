package com.github.backend_1st_project.repository.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsJpaRepository extends JpaRepository<PostEntity, Integer> {

    List<PostEntity> findByUserId(String userId);
}
