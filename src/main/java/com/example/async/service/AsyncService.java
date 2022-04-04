package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    @Async  // Async로 돌리고 싶은 부분에 이 어노테이션 붙여주기
    public void hello() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(2000);
                log.info("Thread sleep ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
