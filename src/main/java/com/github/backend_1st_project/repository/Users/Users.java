package com.github.backend_1st_project.repository.Users;

import com.github.backend_1st_project.repository.users_role.UserRole;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name="users")
@Builder
public class Users {
    @Id @Column(name="user_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name="user_pwd")
    private String password;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_address")
    private String email;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "users")
    private Collection<UserRole> userRoleList;

}
