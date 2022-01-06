package com.example.ioc_di_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocDiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocDiSpringApplication.class, args);  // spring application 실행

        // spring application 실행이 되고 난 후, 가져온다.
        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // <bean을 찾는 방법>
        // 1. class 타입으로 찾기
        // 2. 이름으로 찾기

        // 우리가 DI는 해줄 것 이지만 IOC 즉, 객체 관리는 우리가 new로 관리하지 않을 것이다.
        // 1. bean을 class 타입으로 찾는 방법
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        Encoder encoder = new Encoder(base64Encoder);
//        String result = encoder.encode(url);
//        System.out.println(result);
//
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//        encoder.setIEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);

        // -> 이전에 우리가 new로 만들었던 Base64Encoder와 UrlEncoder를
        //    이제는 스프링이 관리할 수 있도록 annotation을 붙였다. 즉 스프링에게 권한을 넘겼다.
        //    = 제어의 역전이 일어난 것이다. 어플리케이션이 빈을 관리하기 때문에 IOC라고 한다.

        // ! 그렇다면 이제 Encoder도 만들 수 있지 않나요?! 네!! 만들어봅시다.
        Encoder encoder = context.getBean(Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);
        // 이제 우리의 코드에서는 new로 생성하는 코드를 절대로 찾아볼 수 없게 되었다.
        // 즉, 모든 권한이 spring에게 넘어갔다.
    }

}
