package com.example.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    // getForObject()든, getForEntity()든 server에서는 바뀌는 코드가 없다.
    @GetMapping("/hello")
    public String hello(){
        return "hello server";
    }
}
