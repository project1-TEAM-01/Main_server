package com.github.backend_1st_project.web.controller;

import com.github.backend_1st_project.service.UserService;
import com.github.backend_1st_project.web.dto.ResultResponse;
import com.github.backend_1st_project.web.dto.users.RequestUser;
import com.github.backend_1st_project.web.dto.users.UsersDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"유저 API"})
public class UsersController {

    private final UserService userService;


    @PostMapping("/signup")
    @ApiOperation(value="유저 등록", notes="유저 정보를 등록")
    public String registerUser(@RequestBody RequestUser userBody){
        return userService.saveUser(userBody);
    }

    @GetMapping("/users")
    @ApiOperation(value="유저 정보 전체 조회", notes="유저 정보를 전체조회")
    public ResultResponse findAllUser(){
        List<UsersDTO> users = userService.findAllUser();
        return new ResultResponse(users);
    }

    @GetMapping("/users/{userId}")
    @ApiOperation(value="유저 정보 조회", notes="특정 유저 정보를 조회")
    @ApiImplicitParam(name = "userId", value = "현재 등록된 유저 id")
    public ResultResponse findByUserId(@PathVariable String userId){
        List<UsersDTO> users = userService.findByUser(userId);
        return new ResultResponse(users);
    }


}
