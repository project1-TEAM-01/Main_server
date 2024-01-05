package com.github.backend_1st_project.service.mapper;

import com.github.backend_1st_project.web.dto.comments.CommentDTO;
import com.github.backend_1st_project.repository.comments.CommentEntity;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T16:48:38+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDTO entityToDTO(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setPostId( commentEntity.getPostId() );
        commentDTO.setUserId( commentEntity.getUserId() );
        commentDTO.setContent( commentEntity.getContent() );
        commentDTO.setCommentId( commentEntity.getCommentId() );
        if ( commentEntity.getCreatedAt() != null ) {
            commentDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( commentEntity.getCreatedAt() ) );
        }
        if ( commentEntity.getUpdatedAt() != null ) {
            commentDTO.setUpdatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( commentEntity.getUpdatedAt() ) );
        }

        return commentDTO;
    }
}
