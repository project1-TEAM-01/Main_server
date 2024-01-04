package com.github.backend_1st_project.repository.comments;


import com.github.backend_1st_project.repository.Users.Users;
import com.github.backend_1st_project.repository.posts.Posts;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name="comments")
@Builder
public class Comments {
    @Id @Column(name="comment_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    @Column(name="content")
    private String content;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
