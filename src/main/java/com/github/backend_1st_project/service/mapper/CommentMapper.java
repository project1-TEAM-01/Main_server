package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.repository.comments.Comments;
import com.github.backend_1st_project.web.dto.ViewCommentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);


    @Mapping(target="id",source = "commentId")
    @Mapping(target="post_id",source = "posts.postId")
    @Mapping(target="email",source = "users.email")
    @Mapping(target="content",source = "content")
    @Mapping(target="created_at",source = "createdAt")
    ViewCommentsDto commentToViewCommentDto(Comments comments);
}
