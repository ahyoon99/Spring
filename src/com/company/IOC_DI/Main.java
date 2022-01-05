package com.company.IOC_DI;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // 1) 아무 기법사용 안한 코드
        // 요구사항1) Base 64로 encoding 해주세요
        Base64Encoder encoder = new Base64Encoder();
        String result = encoder.encode(url);
        System.out.println(result);

        // 요구사항2) url encoding도 해주세요
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
        System.out.println(urlResult);

        // 요구사항이 늘어날 수록 Encoder를 하나씩 새로 만들어야한다.

    }
}
