package com.github.backend_1st_project.repository.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersJpaRepository extends JpaRepository<UsersEntity, Integer> {

    boolean existsByEmail(String email);

    UsersEntity findByEmailEquals(String email);
}
