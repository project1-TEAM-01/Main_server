package com.github.backend_1st_project.service;

import com.github.backend_1st_project.repository.Users.UserJpaRepository;
import com.github.backend_1st_project.repository.Users.Users;
import com.github.backend_1st_project.repository.comments.CommentJpaRepository;
import com.github.backend_1st_project.repository.comments.Comments;
import com.github.backend_1st_project.repository.posts.PostJpaRepository;
import com.github.backend_1st_project.repository.posts.Posts;
import com.github.backend_1st_project.service.exceptions.NotFoundException;
import com.github.backend_1st_project.service.mapper.CommentMapper;
import com.github.backend_1st_project.service.mapper.PostMapper;
import com.github.backend_1st_project.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final CommentJpaRepository commentJpaRepository;

       public Integer postingDoc(PostDoc postDoc) {
        String title = postDoc.getTitle();
        String content = postDoc.getContent();
        // 토큰 구현시 토큰에서 id가져와서 post에 넣어주는 방식으로 바꾸기
        // 토큰 구현하면 author도 새로작성
        String email = postDoc.getEmail();
        Users user = userJpaRepository.findByEmailEquals(email);
        Posts post = new Posts(null,title,content,user,null,null, LocalDateTime.now(),null);
        Posts postResult = postJpaRepository.save(post);
        return postResult.getPostId();
    }


    public List<ViewPostDto> findAllPost() {
        List<Posts> posts = postJpaRepository.findAll();
        return posts.stream().map(PostMapper.INSTANCE::postToViewPostDto).collect(Collectors.toList());
    }

    public List<ViewPostDto> findPostByEmail(String email) {
        Users user = userJpaRepository.findByEmailEquals(email);
        List<Posts> posts = postJpaRepository.findByUsersEmail(email);
        return posts.stream().map(PostMapper.INSTANCE::postToViewPostDto).collect(Collectors.toList());
    }

    public void updatePost(String postId, ModifyPost modifyPost) {
        Integer postID = Integer.valueOf(postId);
        Posts post = postJpaRepository.findById(postID).orElseThrow(()->new NotFoundException("해당 게시물을 찾을 수 없습니다."));
        String modifyContent = modifyPost.getContent();
        String modifyTitle = modifyPost.getTitle();
        post.setContent(modifyContent);
        post.setTitle(modifyTitle);
        post.setUpdatedAt(LocalDateTime.now());
        postJpaRepository.save(post);
    }

    public Integer writeComment(CommentDto commentDto) {
        Integer postid = commentDto.getPostId();
        String content = commentDto.getContent();
        String email = commentDto.getEmail();
        Posts post = postJpaRepository.findById(postid).orElseThrow(()->new NotFoundException("해당 게시물을 찾을 수 없습니다."));
        Users user = userJpaRepository.findByEmailEquals(email);
        Comments comment = new Comments(null,post,user,content,LocalDateTime.now(),null);
        Comments commentResult = commentJpaRepository.save(comment);
        return commentResult.getCommentId();
    }

    public List<ViewCommentsDto> findAllComment() {
        List<Comments> comments =commentJpaRepository.findAll();
        return comments.stream().map(CommentMapper.INSTANCE::commentToViewCommentDto).collect(Collectors.toList());
    }

    public void updateComment(String commentId, ModifyComment modifyComment) {
        Integer commentID = Integer.valueOf(commentId);
        String content = modifyComment.getContent();
        Comments comment = commentJpaRepository.findById(commentID).orElseThrow(()->new NotFoundException("해당 댓글을 찾을 수 없습니다."));
        comment.setContent(content);
        comment.setUpdatedAt(LocalDateTime.now());
        commentJpaRepository.save(comment);
    }
}
