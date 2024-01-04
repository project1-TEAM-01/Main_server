package com.github.backend_1st_project.repository.users;

import com.github.backend_1st_project.repository.UserRole.UserRoleEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name="users")
@Builder
public class UsersEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "user_pwd")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "users")
    private List<UserRoleEntity> userRoleList;
}