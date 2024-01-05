package com.github.backend_1st_project.web.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "userEmail")
@Entity
@Table(name = "users")
public class UserEntity extends TimeEntity {
    @Id
    @Column(name = "user_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "user_pwd")
    private String userPwd;
    @Column(name = "user_email", length = 30)
    private String userEmail;
    @OneToMany(mappedBy = "users")
    private List<UserRoleEntity> userRoleList;
}
