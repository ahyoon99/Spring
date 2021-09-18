package com.company.designPattern.adapter;

// 220V를 110V로 변환해줄것이다.
public class SocketAdapter implements Electronic110V{

    // 자기자신이 연결시켜줘야할 220V를 가지고 있어야한다.
    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
