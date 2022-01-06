package com.example.ioc_di_spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// 직접 application context 즉, spring container에 접근해서 객체를 가져오기 위해서 필요한 코드
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    // applicationContext를 context 변수에 주입해준다.
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    // static method하나 만들어주었다.
    public static ApplicationContext getContext() {
        return context;
    }
}

// 스프링 어플리케이션이 실행이 될 때, 즉 ApplicationContextProvider를 만들 때
// applicationContext를 context로 주입해 줄 것이다.
