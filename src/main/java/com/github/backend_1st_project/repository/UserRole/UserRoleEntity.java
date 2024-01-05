package com.github.backend_1st_project.repository.UserRole;
import com.github.backend_1st_project.repository.users.UsersEntity;
import com.github.backend_1st_project.repository.Role.RolesEntity;
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
public class UserRoleEntity {

        @Id @Column(name="users_role_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer userRoleId;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="user_id")
        private UsersEntity users;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="role_id")
        private RolesEntity role;

}
