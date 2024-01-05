package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.repository.posts.PostEntity;
import com.github.backend_1st_project.web.dto.posts.PostsDTO;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T16:43:32+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostsDTO entityToDTO(PostEntity postEntity) {
        if ( postEntity == null ) {
            return null;
        }

        PostsDTO postsDTO = new PostsDTO();

        if ( postEntity.getPostId() != null ) {
            postsDTO.setPostId( String.valueOf( postEntity.getPostId() ) );
        }
        postsDTO.setTitle( postEntity.getTitle() );
        postsDTO.setUserId( postEntity.getUserId() );
        postsDTO.setViewCount( postEntity.getViewCount() );
        postsDTO.setLikeCount( postEntity.getLikeCount() );
        if ( postEntity.getCreatedAt() != null ) {
            postsDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( postEntity.getCreatedAt() ) );
        }
        if ( postEntity.getUpdatedAt() != null ) {
            postsDTO.setUpdatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( postEntity.getUpdatedAt() ) );
        }

        return postsDTO;
    }
}
