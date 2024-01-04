package com.github.backend_1st_project.service;

import com.github.backend_1st_project.config.security.JwtTokenProvider;
import com.github.backend_1st_project.repository.Users.UserJpaRepository;
import com.github.backend_1st_project.repository.Users.Users;
import com.github.backend_1st_project.repository.role.Role;
import com.github.backend_1st_project.repository.users_role.UserRole;
import com.github.backend_1st_project.service.exceptions.NotAcceptException;
import com.github.backend_1st_project.web.dto.LoginOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginOutService {
    private final UserJpaRepository userJpaRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Transactional(transactionManager = "tmJpa1")
    public String login(LoginOutDto loginDto) {
        String email = loginDto.getEmail();
        String pwd = loginDto.getPassword();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, pwd)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Users users = userJpaRepository.findByEmailEquals(email);
            List<String> roles = users.getUserRoleList().stream().map(UserRole::getRole).map(Role::getRoleName).collect(Collectors.toList());
            return jwtTokenProvider.createToken(email, roles);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotAcceptException("로그인 할 수 없습니다.");
        }
    }


    @Transactional(transactionManager = "tmJpa1")
    public void logout(LoginOutDto logOutDto) {
        String email = logOutDto.getEmail();
        userJpaRepository.deleteByEmail(email);
    }
}
