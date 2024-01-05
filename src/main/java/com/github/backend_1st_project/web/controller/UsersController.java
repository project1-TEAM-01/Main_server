package com.github.backend_1st_project.web.controller;

import com.github.backend_1st_project.service.UserService;
import com.github.backend_1st_project.web.dto.users.LoginDto;
import com.github.backend_1st_project.web.dto.users.SignUpDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"유저 API"})
public class UsersController {

    private final UserService userService;

    @ApiOperation("이메일 비밀번호 입력하여 회원 가입 API")
    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        boolean isSuccess = userService.signup(signUpDTO);
        return isSuccess ? "회원가입 성공하였습니다." : "회원가입 실패하였습니다.";
    }

    @ApiOperation("이메일 비밀번호 입력하여 접속하는 api")
    @PostMapping("/login")
    public String loginSuccess(@RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse){
        String token = userService.login(loginDto);
        httpServletResponse.setHeader("X-AUTH-TOKEN",token);
        return "로그인이 성공하였습니다!";
    }

//    // 로그아웃 ???? 삭제??????
//    @ApiOperation("접속된 유저 로그아웃/유저 삭제해버리는 로직")
//    @PostMapping("/logout")
//    private String logOut(@RequestBody LoginOutDto logOutDto){
//        loginOutService.logout(logOutDto);
//        return "로그아웃이 성공적으로 완료 되었습니다!";
//    }
//
//
//
//
//    @PostMapping("/signup")
//    @ApiOperation(value="유저 등록", notes="유저 정보를 등록")
//    public String registerUser(@RequestBody RequestUser userBody){
//        return userService.saveUser(userBody);
//    }
//
//    @GetMapping("/users")
//    @ApiOperation(value="유저 정보 전체 조회", notes="유저 정보를 전체조회")
//    public ResultResponse findAllUser(){
//        List<UsersDTO> users = userService.findAllUser();
//        return new ResultResponse(users);
//    }
//
//    @GetMapping("/users/{userId}")
//    @ApiOperation(value="유저 정보 조회", notes="특정 유저 정보를 조회")
//    @ApiImplicitParam(name = "userId", value = "현재 등록된 유저 id")
//    public ResultResponse findByUserId(@PathVariable String userId){
//        List<UsersDTO> users = userService.findByUser(userId);
//        return new ResultResponse(users);
//    }


}
