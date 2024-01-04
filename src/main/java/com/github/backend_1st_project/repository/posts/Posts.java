package com.github.backend_1st_project.repository.posts;

import com.github.backend_1st_project.repository.Users.Users;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name="posts")
@Builder
public class Posts {
    @Id @Column(name="post_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;
    @Column(name="view_count")
    private Integer viewCount;
    @Column(name="like_count")
    private Integer LikeCount;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
