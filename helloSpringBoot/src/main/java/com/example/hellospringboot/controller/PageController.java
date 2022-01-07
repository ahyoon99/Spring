package com.example.hellospringboot.controller;

import com.example.hellospringboot.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 페이지를 리턴하는 서버를 작성할 수 있다.
@Controller // -> String을 리턴하면 리소스를 찾게된다.
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    // @controller에서는 return이 String이 되면 자동으로 리소스에 있는 html파일을 찾아가게된다.
    // 이때, json을 어떻게 내려줄 것인가?
    // 1) ResponseEntity

    // 2) @ResponseBody : 객체 자체를 리턴하였을 때 리소스를 찾지않고 Response Body를 만들어서 내려준다.
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();
        user.setName("steve");
        user.setAddress("Jeonju");
        return user;
    }
}
