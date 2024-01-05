package com.github.backend_1st_project.web.dto.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "userId")
@Entity
@Table(name = "users")
public class UserEntity extends TimeEntity {
    @Id
    @Column(name = "user_id", length = 30) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column(name = "user_pwd")
    private String userPwd;
    @Column(name = "user_name", length = 30)
    private String userName;
    @Column(name = "user_address", length = 100)
    private String userAddress;
    @Column(name = "role_id", nullable = false, columnDefinition = "DEFAULT 2")
    private Integer roleId;
}
