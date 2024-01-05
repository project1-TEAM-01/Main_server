package com.github.backend_1st_project.web.dto.users;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUser {
    private String userEmail;
    private String password;
}
