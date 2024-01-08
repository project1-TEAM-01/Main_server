package com.github.backend_1st_project.repository.Role;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name="role")
@Builder
public class RolesEntity {
        @Id
        @Column(name="role_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer roleId;
        @Column(name="role_name")
        private String roleName;
    }

