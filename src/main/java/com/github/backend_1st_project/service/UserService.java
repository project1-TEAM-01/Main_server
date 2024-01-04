package com.github.backend_1st_project.service;

import com.github.backend_1st_project.web.dto.entity.UserEntity;
import com.github.backend_1st_project.repository.users.UsersJpaRepository;
import com.github.backend_1st_project.service.exception.NotFoundException;
import com.github.backend_1st_project.service.mapper.UserMapper;
import com.github.backend_1st_project.web.dto.users.RequestUser;
import com.github.backend_1st_project.web.dto.users.UsersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersJpaRepository usersJpaRepository;

    public List<UsersDTO> findByUser(String userId) {
        List<UserEntity> userEntity = usersJpaRepository.findByUserId(userId);
        if(userEntity.isEmpty())
            throw new NotFoundException("해당 ID: " + userId + "를 찾을 수 없습니다.");
        List<UsersDTO> userDto = userEntity.stream().map(UserMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
        return userDto;
    }

    public List<UsersDTO> findAllUser() {
        List<UserEntity> userEntity = usersJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "userId"));
        List<UsersDTO> userDto = userEntity.stream().map(UserMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
        return userDto;
    }

    public String saveUser(RequestUser userBody) {
//        UserEntity user = UserMapper.INSTANCE.entityToDTO()
        return "회원가입이 완료되었습니다.";
    }
}
