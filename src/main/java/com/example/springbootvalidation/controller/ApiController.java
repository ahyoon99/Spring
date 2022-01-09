package com.example.springbootvalidation.controller;

import com.example.springbootvalidation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public User user(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
//        if (user.getAge()>=90){ // age가 90이상이면 에러를 던져준다.
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
//        return ResponseEntity.ok(user);
    }
}
