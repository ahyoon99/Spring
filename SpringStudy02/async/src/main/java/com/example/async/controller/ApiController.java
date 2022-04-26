package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsyncService asyncService;

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/hello")
    public CompletableFuture hello(){
        // CompletableFuture는 다른 쓰레드에서 실행을 시키고 결과러 반환받는 형태이다.
        log.info("completable future init");
        return asyncService.run();
    }
}
