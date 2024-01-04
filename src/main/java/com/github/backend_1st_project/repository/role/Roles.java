//package com.github.backend_1st_project.repository.role;
//
//import com.github.backend_1st_project.service.advice.InvalidException;
//
//public enum Roles {
//    GENERAL_USER("일반회원"),
//    ADMIN_USER("관리자");
//
//    private final String roleName;
//
//    Roles(String roleName){
//        this.roleName = roleName;
//    }
//
//    public static Roles valueOfroleName(String str){
//        for(Roles role: values()) {
//            if (role.roleName.equals(str)) return role;
//        }throw new InvalidException("Role은 '일반회원'또는 '관리자'이어야 합니다");
//    }
//}


