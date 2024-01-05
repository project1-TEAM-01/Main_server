package com.github.backend_1st_project.web.dto.comments;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentBody {
    private String content;
    private String author;
    private Integer postId;
}
