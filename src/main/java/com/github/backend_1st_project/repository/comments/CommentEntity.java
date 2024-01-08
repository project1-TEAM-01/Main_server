package com.github.backend_1st_project.repository.comments;


import com.github.backend_1st_project.web.dto.comments.CommentBody;
import com.github.backend_1st_project.web.dto.entity.TimeEntity;
import com.github.backend_1st_project.web.dto.posts.PostBody;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "commentId")
@Entity
@Table(name = "comments")
public class CommentEntity extends TimeEntity {
    @Id
    @Column(name = "comment_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "content")
    private String content;

    public CommentEntity(Integer commendId, Integer postId, String userId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public void setCommentBody(CommentBody postBody){
        this.content = postBody.getContent();
        this.userId = postBody.getUserId();
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
