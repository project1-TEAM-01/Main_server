package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.web.dto.comments.CommentDTO;
import com.github.backend_1st_project.repository.comments.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper{
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "content", source = "content")
    CommentDTO entityToDTO(CommentEntity commentEntity);
}
