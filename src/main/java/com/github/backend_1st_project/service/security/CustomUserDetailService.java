package com.github.backend_1st_project.service.security;

import com.github.backend_1st_project.repository.Users.UserJpaRepository;
import com.github.backend_1st_project.repository.Users.Users;
import com.github.backend_1st_project.repository.role.Role;
import com.github.backend_1st_project.repository.userDetails.CustomUserDetails;
import com.github.backend_1st_project.repository.users_role.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipal;
import java.util.stream.Collectors;

@Primary
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserJpaRepository userJpaRepository;

    @Transactional(transactionManager = "tmJpa1")
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userJpaRepository.findByEmailEquals(email);


        return CustomUserDetails.builder()
                .userId(users.getUserId())
                .email(users.getEmail())
                .password(users.getPassword())
                .authorities(users.getUserRoleList().stream()
                        .map(UserRole::getRole)
                        .map(Role::getRoleName)
                        .collect(Collectors.toList())).build();


    }
}
