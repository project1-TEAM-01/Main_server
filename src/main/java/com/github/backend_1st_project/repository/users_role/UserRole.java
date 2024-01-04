package com.github.backend_1st_project.repository.users_role;


import com.github.backend_1st_project.repository.Users.Users;
import com.github.backend_1st_project.repository.role.Role;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name="users_role")
@Builder
public class UserRole {
    @Id @Column(name="users_role_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users users;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;
}
