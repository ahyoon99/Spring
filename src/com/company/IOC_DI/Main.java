package com.company.IOC_DI;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // 1) 아무 기법사용 안한 코드
        // 요구사항1) Base 64로 encoding 해주세요
//        Base64Encoder encoder = new Base64Encoder();
//        String result = encoder.encode(url);
//        System.out.println(result);
//
//        // 요구사항2) url encoding도 해주세요
//        UrlEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);
//        System.out.println(urlResult);

        // 요구사항이 늘어날 수록 Encoder를 하나씩 새로 만들어야한다.
        // +) 추상화를 적용 시켜보겠다.
        // 2) interface 생성 한 후의 코드
//        IEncoder encoder = new Base64Encoder();
//        String result = encoder.encode(url);
//        System.out.println(result);
//
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);
//        System.out.println(urlResult);

        // 인터페이스 하나가 생겼지만 나의 코드는 그다지 변하지 않았다.
        // 3) Encoder 생성하여 코드 줄이기 : Encoder를 건들여서 동작한다.
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);

    }
}
