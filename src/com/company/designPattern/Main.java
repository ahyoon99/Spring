package com.company.designPattern;

import com.company.designPattern.singleton.AClazz;
import com.company.designPattern.singleton.BClazz;
import com.company.designPattern.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {

        // 1. singleton pattern : 어떤 클래스(객체)가 유일하게 1개만 존재할 때 사용한다.
        // ex ) 프로그래밍에서 TCP Socket통신에서 서버와 연결된 connect 객체에 주로 사용한다. Socket자체는 한개만 사용한다.
        // ex ) 스프링에서 빈이라고 부르는 객체(클래스)는 기본적으로 싱글톤으로 관리된다.
        // - 디폴트 생성자를 private으로 막아버린다.
        // - getInstance라는 method를 통해서 생성되어 있는 객체들을 가지고 온다. 이때 객체가 없는 경우, 객체를 새로 생성해준다.
        //      : 그 결과, 어떠한 클래스에서 getInstance를 하였을 때 동일한 객체를 얻을 수 있다.
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));    // 객체가 동일한지 체크하기 위해서 equals() 사용한다.

    }
}
