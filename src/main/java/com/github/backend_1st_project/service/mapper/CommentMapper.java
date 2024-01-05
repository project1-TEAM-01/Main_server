package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.web.dto.comments.CommentDTO;
import com.github.backend_1st_project.web.dto.entity.CommentEntity;
import com.github.backend_1st_project.web.dto.entity.PostEntity;
import com.github.backend_1st_project.web.dto.posts.PostsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Mapper
public interface CommentMapper{
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "content", source = "content")
    CommentDTO entityToDTO(CommentEntity commentEntity);
}
