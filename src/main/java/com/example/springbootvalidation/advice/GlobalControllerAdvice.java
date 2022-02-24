package com.example.springbootvalidation.advice;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(basePackages = "com.example.exception.controller") // 해당 패키지 아래에 있는 exception을 처리할 수 있게 된다.
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)  // 어떤 error를 잡을지 적어준다.
    public ResponseEntity exception(Exception e){
        System.out.println(e.getClass().getName());
        System.out.println("-----------------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("-----------------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");    // INTERNAL_SERVER_ERROR : 서버에서 일어난 에러이다.

    }

    // 특정 method의 exception을 잡고 싶을 때
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("Global Exception");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
