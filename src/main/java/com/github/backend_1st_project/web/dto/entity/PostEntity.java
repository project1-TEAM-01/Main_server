package com.github.backend_1st_project.web.dto.entity;

import com.github.backend_1st_project.web.dto.posts.PostBody;
import lombok.*;

import javax.persistence.*;
import java.security.PublicKey;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "postId")
@Entity
@Table(name = "posts")
public class PostEntity extends TimeEntity {
    @Id
    @Column(name = "post_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "title", nullable = false, length = 30)
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "view_count", columnDefinition = "DEFAULT 0")
    private Integer viewCount;
    @Column(name = "like_count", columnDefinition = "DEFAULT 0")
    private Integer likeCount;

    public PostEntity(Integer postId, String title, String content, String userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.viewCount = 0;
        this.likeCount = 0;
        this.content = content;
    }

    public void setPostBody(PostBody postBody){
        this.title = postBody.getTitle();
        this.content = postBody.getContent();
        this.userId = postBody.getUserId();
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
