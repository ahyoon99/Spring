package com.example.springbootvalidation.controller;

import com.example.springbootvalidation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){  // required = false는 값이 없어도 에러가 나지 않도록 한다.
        User user = new User();
        user.setName(name);
        user.setAge(age);

        // 예외 발생시키기
        int a = 10 + age;    // NullPointerException 발생

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }


    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){

        // @Valid에 대한 결과가 bindingResult에 들어오게 된다.
        // 즉, 이전처럼 바로 예외가 터지는 것이 아니다.
        if(bindingResult.hasErrors()){  // bindingResult가 에러를 가지고 있는지 없는지
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError)objectError; // 어떠한 field에서 에러가 났는지를 가져온다.
                String message = objectError.getDefaultMessage();   // 그에 대한 메시지도 가져온다.

                System.out.println("field : "+ field.getField());
                System.out.println(message);

                sb.append("field : "+field.getField());
                sb.append("message : "+message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        // logic

        return ResponseEntity.ok(user);
    }
}
