package com.github.backend_1st_project.service;

import com.github.backend_1st_project.repository.Users.Users;
import com.github.backend_1st_project.repository.Users.UserJpaRepository;
import com.github.backend_1st_project.repository.role.Role;
import com.github.backend_1st_project.repository.role.RoleRepository;
import com.github.backend_1st_project.repository.users_role.UserRole;
import com.github.backend_1st_project.repository.users_role.UserRoleRepository;
import com.github.backend_1st_project.service.exceptions.NotFoundException;
import com.github.backend_1st_project.web.dto.SignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final RoleRepository roleRepository;
    private final UserJpaRepository userJpaRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional(transactionManager = "tmJpa1")
    public boolean signupUser(SignUpDTO signUpDTO) {
        String email = signUpDTO.getEmail();
        String password = signUpDTO.getPassword();
        String username= signUpDTO.getUsername();

        if(userJpaRepository.existsByEmail(email)){
            return false;
        }
        Role role = roleRepository.findByRoleName("ROLE_USER").orElseThrow(()->new NotFoundException("ROLE_USER를 찾을 수 없습니다."));
//        String encodePassword = passwordEncoder.encode(password);
        Users user = Users.builder()
                .email(email).password(passwordEncoder.encode(password)).userName(username)
                .createdAt(LocalDateTime.now()).build();
//                new Users(null,encodePassword,username,email, LocalDateTime.now(),null);

        userJpaRepository.save(user);
        userRoleRepository.save(UserRole.builder().role(role).users(user).build());
        return true;
    }
}
