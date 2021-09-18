package com.company.designPattern.singleton;

public class BClazz {
    private SocketClient socketClient;

    public BClazz(){
        this.socketClient = SocketClient.getInstance();

        // 싱글톤 안쓰는 경우
        // this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
