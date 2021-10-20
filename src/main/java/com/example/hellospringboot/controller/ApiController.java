package com.example.hellospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class는 Rest API를 처리하는 Controller가 된다.
@RequestMapping("/api") // RequestMapping은 URI를 지정해주는 Annotation이다.
public class ApiController {

    @GetMapping("/hello")   // http://localhost:8080/api/hello 라는 주소와 매핑되었다.
    public String hello(){
        return "hello spring boot!";
    }
}
