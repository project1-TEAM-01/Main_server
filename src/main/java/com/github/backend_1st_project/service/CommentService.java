package com.github.backend_1st_project.service;

import com.github.backend_1st_project.repository.comments.CommentsJpaRepository;
import com.github.backend_1st_project.repository.posts.PostsJpaRepository;
import com.github.backend_1st_project.service.exception.NotFoundException;
import com.github.backend_1st_project.service.mapper.CommentMapper;
import com.github.backend_1st_project.web.dto.comments.CommentBody;
import com.github.backend_1st_project.web.dto.comments.CommentDTO;
import com.github.backend_1st_project.web.dto.entity.CommentEntity;
import com.github.backend_1st_project.web.dto.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentsJpaRepository commentsJpaRepository;
    public List<CommentDTO> findPostByComments(Integer postId) {
        List<CommentEntity> comments = commentsJpaRepository.findByPostId(postId);
        if(comments.isEmpty())
            throw new NotFoundException("존재하지 않는 댓글입니다.");
        List<CommentDTO> dto = comments.stream().map(CommentMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
        return dto;
    }

    @Transactional
    public String saveComment(CommentBody body){
        CommentEntity comments = new CommentEntity(null, body.getPostId(),  body.getUserId(), body.getContent(), LocalDateTime.now(), LocalDateTime.now());
        commentsJpaRepository.save(comments);
        return "댓글이 성공적으로 작성되었습니다.";
    }

    @Transactional
    public String updateComment(Integer commentId, CommentBody body) {
        CommentEntity comments = commentsJpaRepository.findById(commentId).orElseThrow(() -> new NotFoundException("해당 댓글이 존재하지 않습니다."));
        comments.setCommentBody(body);
        return "댓글이 성공적으로 수정되었습니다.";
    }

    @Transactional
    public String deleteComment(Integer commentId) {
        commentsJpaRepository.deleteById(commentId);
        return "댓글이 성공적으로 삭제되었습니다.";
    }
}
