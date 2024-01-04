package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.repository.posts.Posts;
import com.github.backend_1st_project.web.dto.ViewPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

@Mapping(target = "id", source="postId")
@Mapping(target="title", source="title")
@Mapping(target="content", source="content")
@Mapping(target="email", source="users.email")
@Mapping(target="createdAt", source="createdAt")
ViewPostDto postToViewPostDto(Posts posts);


}
