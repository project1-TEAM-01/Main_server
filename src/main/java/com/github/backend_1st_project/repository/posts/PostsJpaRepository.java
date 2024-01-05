package com.github.backend_1st_project.repository.posts;

import com.github.backend_1st_project.web.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsJpaRepository extends JpaRepository<PostEntity, Integer> {

    @Query("SELECT c FROM PostEntity c WHERE c.user.userEmail = :userEmail")
    List<PostEntity> findByUserId(String userEmail);

    PostEntity findByPostId(Integer postId);
}
