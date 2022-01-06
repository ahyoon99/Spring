package com.example.ioc_di_spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  // 이 어노테이션을 붙이면 에러가 난다.
            // 왜? -> 두가지 타입이 있다. 빈을 스프링에서 선택할 때 빈이 한개만 있으면 바로 매칭이 된다.
            // 하지만 지금처럼 빈이 2개(Base64Encoder, UrlEncoder)가 있을 경우, 스프링에서 어떤것을 매칭해주어야하는지 결정을 못해준다.
            // 이럴때 스프링에서 어떤 것을 매칭해주는지 지정을 해주면 에러가 없어진다.
            //  : @Qualifier("bean의 이름") 을 넣어주면 된다.
            //  이때 bean의 이름은 class에 아무런 명칭 없이 생성하게 된다면 앞글자가 소문자로 변경된 class 이름이 bean의 이름이 된다.
            // 만약 bean의 이름을 따로 지정해주고 싶다면 @Component("bean의 이름")을 달아주면 된다.
public class Encoder {

    private IEncoder iEncoder;

    // 3) 코드
//    public Encoder(){
//        this.iEncoder = new Base64Encoder();
//        //this.iEncoder = new UrlEncoder();
//    }
//
//    public String encode(String message){
//        return iEncoder.encode(message);
//    }

    // 4) 코드
    public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }

}
