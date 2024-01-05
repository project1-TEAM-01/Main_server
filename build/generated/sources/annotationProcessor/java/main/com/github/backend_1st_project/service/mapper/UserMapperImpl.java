package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.web.dto.users.UsersDTO;
import com.github.backend_1st_project.web.entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-06T03:05:29+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UsersDTO entityToDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setEmail( userEntity.getUserEmail() );
        usersDTO.setCreatedAt( userEntity.getCreatedAt() );

        return usersDTO;
    }
}
