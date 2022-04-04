package com.example.async.service;

import jdk.jshell.SourceCodeAnalysis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async
    public CompletableFuture run(){
        // 반환형이 CompletableFuture일때 Completable을 별도의 쓰레드에서 실행시켜준다.
        return new AsyncResult(hello()).completable();
    }

    //@Async  // Async로 돌리고 싶은 부분에 이 어노테이션 붙여주기
    public String hello() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(2000);
                log.info("Thread sleep ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";
    }
}
