package com.company.designPattern.singleton;

public class SocketClient {

    // 싱글톤은 자기자신을 객체로 가지고 있어야 한다.
    private static SocketClient socketClient = null;

    // 싱글톤은 기본 생성자를 private으로 막아야 한다.
    private SocketClient(){

    }

    // 싱글톤 안쓰는 경우
//    public SocketClient(){
//
//    }

    // 싱글톤은 static으로 된 getInstance 메소드를 제공해야한다.
    // static 메소드이기 때문에 어떠한 클래스에서도 바로 getInstance()에 접근이 가능하다.
    public static SocketClient getInstance(){
        if( socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
