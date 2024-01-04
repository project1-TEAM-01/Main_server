package com.github.backend_1st_project.web.dto.users;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUser {
    private String userId;
    private String password;
    private String userName;
    private String userAddress;
}
