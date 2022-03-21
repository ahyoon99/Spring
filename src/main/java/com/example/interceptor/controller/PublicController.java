package com.example.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController { // 권한이 없는 사용자 모두가 들어올 수 있다. open api 형태로 만들 것이다.

    @GetMapping("/hello")
    public String hello(){
        return "public hello";
    }
}
