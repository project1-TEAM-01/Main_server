package com.github.backend_1st_project.repository.userRole;

import com.github.backend_1st_project.web.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleJpaRepository extends JpaRepository<UserRoleEntity,Integer> {

}
