package com.github.backend_1st_project.web.dto.comments;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentBody {
    private Integer postId;
    private String userId;
    private String content;
}
