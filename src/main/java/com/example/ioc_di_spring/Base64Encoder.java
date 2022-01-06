package com.example.ioc_di_spring;

import org.springframework.stereotype.Component;

import java.util.Base64;

//@Component  // bean으로 등록하기 위해서 달아준다. 이 클래스는 스프링에서 bean으로 만들어 관리해준다.
@Component("base74Encoder")
public class Base64Encoder implements IEncoder{

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}
