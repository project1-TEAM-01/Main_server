package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.web.dto.entity.UserEntity;
import com.github.backend_1st_project.web.dto.users.UsersDTO;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T15:59:54+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UsersDTO entityToDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setUserId( userEntity.getUserId() );
        usersDTO.setUserName( userEntity.getUserName() );
        usersDTO.setUserAddress( userEntity.getUserAddress() );
        if ( userEntity.getCreatedAt() != null ) {
            usersDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( userEntity.getCreatedAt() ) );
        }
        if ( userEntity.getUpdatedAt() != null ) {
            usersDTO.setUpdatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( userEntity.getUpdatedAt() ) );
        }

        return usersDTO;
    }
}
