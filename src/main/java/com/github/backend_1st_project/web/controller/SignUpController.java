package com.github.backend_1st_project.web.controller;

import com.github.backend_1st_project.repository.posts.Posts;
import com.github.backend_1st_project.repository.userDetails.CustomUserDetails;
import com.github.backend_1st_project.service.LoginOutService;
import com.github.backend_1st_project.service.PostService;
import com.github.backend_1st_project.service.SignupService;
import com.github.backend_1st_project.web.dto.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SignUpController {


    private final SignupService signupService;
    private final LoginOutService loginOutService;
    private final PostService postService;

    @ApiOperation("이메일 비밀번호 입력하여 회원 가입 API")
    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpDTO signUpDTO){
        boolean isSuccess = signupService.signupUser(signUpDTO);
        return isSuccess ? "회원가입 성공하였습니다." : "회원가입 실패하였습니다.";
    }

    @ApiOperation("이메일 비밀번호 입력하여 접속하는 api")
    @PostMapping("/login")
    public String loginSuccess(@RequestBody LoginOutDto loginDto, HttpServletResponse httpServletResponse){
        String token = loginOutService.login(loginDto);
        httpServletResponse.setHeader("X-AUTH-TOKEN",token);
        return "로그인이 성공하였습니다!";
    }

    // 로그아웃 ???? 삭제??????
    @ApiOperation("접속된 유저 로그아웃/유저 삭제해버리는 로직")
    @PostMapping("/logout")
    private String logOut(@RequestBody LoginOutDto logOutDto){
        loginOutService.logout(logOutDto);
        return "로그아웃이 성공적으로 완료 되었습니다!";
    }


    @ApiOperation("게시물 작성하는 API")
    @PostMapping("/posts")
    private String posting(@RequestBody PostDoc postDoc){
        Integer postId = postService.postingDoc(postDoc);
        return "게시물 "+postId+" 가 성공적으로 작성되었습니다.";
    }

    @ApiOperation("게시물 전체 조회하는 api")
    @GetMapping("/posts")
    private List<ViewPostDto> findAllPost(){
        List<ViewPostDto> posts = postService.findAllPost();
            return posts;
        }

    @ApiOperation("작성자 이메일로 게시물 조회하는 api")
    @GetMapping("/posts/search")
    private List<ViewPostDto> findPostByEmail(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
//            @RequestParam("email") String email
    ){
        String email = customUserDetails.getEmail();
        List<ViewPostDto> posts = postService.findPostByEmail(email);
        return posts;
    }

    @ApiOperation("게시물을 수정하는 api")
    @PutMapping("/posts/{id}")
    private String modifyPost(
            @PathVariable("id") String postId,
            @RequestBody ModifyPost modifyPost
    ){
        postService.updatePost(postId,modifyPost);
     return postId +" 게시물이 정상적으로 수정되었습니다.";
    }


    @ApiOperation("댓글 작성하는 api")
    @PostMapping("/comments")
    public String writeComment(
            @RequestBody CommentDto commentDto
    ){
        Integer commentId = postService.writeComment(commentDto);
        return commentId +" 댓글이 성공적으로 작성되었습니다.";
    }

    @ApiOperation("댓글을 조회하는 api")
    @GetMapping("/comments")
    public List<ViewCommentsDto> findAllComment(){
        return postService.findAllComment();
    }

    @ApiOperation("댓글을 수정하는 api")
    @PutMapping("/comments/{id}")
    public String modifyComment(
            @PathVariable("id") String commentId,
            @RequestBody ModifyComment modifyComment
    ){
        postService.updateComment(commentId,modifyComment);
        return commentId+" 댓글이 정상적으로 수정되었습니다.";
    }

}
