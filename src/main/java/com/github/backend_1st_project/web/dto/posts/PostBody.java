package com.github.backend_1st_project.web.dto.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostBody {
    private String title;
    private String content;
    private String userId;
}
