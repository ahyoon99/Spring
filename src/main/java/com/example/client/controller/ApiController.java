package com.example.client.controller;

import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    // "@Autowired"를 사용하는 방식은 예전에 사용하던 방식이다. 요즘은 아래와 같은 "생성자 주입 방식"으로 바뀌었다.
    // +) "@Autowired"를 사용하고 롬복을 쓰는 간단한 방법도 존재한다.
    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public UserResponse getHello(){
        // 1. get 예제
        //return restTemplateService.hello();

        // 2. post 예제
        // return restTemplateService.post();

        // 3. post 예제 - header에 정보 담아서 보내기
        return restTemplateService.exchange();
    }
}
