package com.github.backend_1st_project.repository.comments;

import com.github.backend_1st_project.repository.comments.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comments,Integer> {



}
