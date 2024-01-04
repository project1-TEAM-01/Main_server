package com.github.backend_1st_project.repository.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<Users,String> {

Users findByEmailEquals(String email);

void deleteByEmail(String email);
boolean existsByEmail(String email);


}
