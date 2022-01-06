package com.example.ioc_di_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocDiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocDiSpringApplication.class, args);  // spring application 실행

        // spring application 실행이 되고 난 후, 가져온다.
        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // <bean을 찾는 방법>
        // 1. class 타입으로 찾기
        // 2. bean의 이름으로 찾기

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
//        Encoder encoder = context.getBean(Encoder.class);
//        String result = encoder.encode(url);
//        System.out.println(result);
        // 이제 우리의 코드에서는 new로 생성하는 코드를 절대로 찾아볼 수 없게 되었다.
        // 즉, 모든 권한이 spring에게 넘어갔다.

        // 2. bean의 이름으로 찾기
        Encoder encoder = context.getBean("base64Encode", Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);

        Encoder encoder2 = context.getBean("urlEncode", Encoder.class);
        String result2 = encoder2.encode(url);
        System.out.println(result2);
    }

}

// 생성하는 또 다른 방법 : 직접 bean을 등록해준다.
@Configuration  // 이 annotation는 하나의 class에서 여러개의 bean을 생성할 것이라는 의미이다. 내부에 @Component를 가지고 있다.
class AppConfig{

    @Bean("base64Encode")   // @Bean : 빈으로 등록해주는 annotation이다. @Bean("bean의 이름")으로도 쓸 수 있다.
    public Encoder encoder(Base64Encoder base64Encoder){    // Base64Encoder를 주입받을 것이다. 사용할 때 개발자가 new로 생성하지 않는다.
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){  // UrlEncoder를 주입받을 것이다.
        return new Encoder(urlEncoder);
    }
}
