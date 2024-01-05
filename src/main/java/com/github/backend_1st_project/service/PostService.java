package com.github.backend_1st_project.service;

import com.github.backend_1st_project.repository.users.UsersJpaRepository;
import com.github.backend_1st_project.service.exception.NotFoundException;
import com.github.backend_1st_project.web.dto.entity.PostEntity;
import com.github.backend_1st_project.repository.posts.PostsJpaRepository;
import com.github.backend_1st_project.service.mapper.PostMapper;
import com.github.backend_1st_project.web.dto.entity.UserEntity;
import com.github.backend_1st_project.web.dto.posts.PostBody;
import com.github.backend_1st_project.web.dto.posts.PostsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceContexts;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostsJpaRepository postsJpaRepository;
    private final UsersJpaRepository usersJpaRepository;
//    @PersistenceContext(type = PersistenceContextType.EXTENDED)
//    private EntityManager em;

    public List<PostsDTO> findAllPost() {
        List<PostEntity> posts = postsJpaRepository.findAll();
        List<PostsDTO> postDto = posts.stream().map(PostMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
        return postDto;
    }

    @Transactional
    public String savePost(PostBody body) {
        List<UserEntity> user = usersJpaRepository.findByUserId(body.getUserId());
        if(user.isEmpty())
            throw new NotFoundException("존재하지 않은 유저입니다.");
        PostEntity posts = new PostEntity(null, body.getTitle(), body.getContent(), body.getUserId(), LocalDateTime.now(), LocalDateTime.now());
        postsJpaRepository.save(posts);
        return "게시물이 성공적으로 작성되었습니다.";
    }

    @Transactional
    public String updatePosts(Integer postId, PostBody postBody) {
        PostEntity postEntity = postsJpaRepository.findById(postId).orElseThrow(() -> new NotFoundException("해당 게시물이 존재하지 않습니다."));
        postEntity.setPostBody(postBody);
        return "게시물 업데이트가 완료되었습니다.";
    }

    @Transactional
    public String deletePosts(Integer postId) {
        PostEntity postEntity = postsJpaRepository.findById(postId).orElseThrow(() -> new NotFoundException("해당 게시물은 이미 존재하지 않습니다."));
        postsJpaRepository.deleteById(postId);
        return "해당 게시물이 삭제되었습니다.";
    }

    public List<PostsDTO> findPostById(String userId) {
        List<PostEntity> posts = postsJpaRepository.findByUserId(userId);
        if(posts.isEmpty())
            throw new NotFoundException("해당 ID: " + userId + "의 게시물을 찾을 수 없습니다.");
        List<PostsDTO> dto = posts.stream().map(PostMapper.INSTANCE::entityToDTO).collect(Collectors.toList());
        return dto;
    }
}
