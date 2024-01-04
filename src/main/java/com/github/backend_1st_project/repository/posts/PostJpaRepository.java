package com.github.backend_1st_project.repository.posts;

import com.github.backend_1st_project.repository.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJpaRepository extends JpaRepository<Posts,Integer> {

    List<Posts> findByUsersEmail(String email);

}
