package com.github.backend_1st_project.repository.role;

import com.github.backend_1st_project.web.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends JpaRepository<RolesEntity, Integer> {
}
