package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth   // interceptor에서 메소드나 컨트롤러에 @Auth가 붙어있으면 세션을 검사해서 있을 때만 통과시킬 것이다.
@Slf4j
public class PrivateController {    // 내부 사용자, 세션이 인증 된 사용자만 넘길 것 이다.

    //@Auth   // 특정 controller에 특정 method에만 달아줄 수 있다. 일관성이 떨어지고 유지보수하기 어려워진다.
    @GetMapping("/hello")
    public String hello(){
        log.info("private hello controller");
        return "private hello";
    }

}
