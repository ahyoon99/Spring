package com.company.designPattern.facade;

// facade 적용하지 않은 것
public class Ftp {

    // Ftp가 포트22번으로 특정한 호스트에 붙어야하기 때문에 호스트와 포트를 알아야한다.
    // Ftp는 특정 path로도 이동해야하기 때문에 path가 있을것이다.
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path){
        this.host = host;
        this.port = port;
        this.path = path;
    }

    // ftp가 제공하는 기본적인 메소드 3가지
    // 1.
    public void connect(){
        System.out.println("FTP Host : "+host+", Port : "+port+"로 연결 합니다.");
    }

    // 2. 이동하는 것
    public void moveDirectory(){
        System.out.println("FTP path : "+path+"로 이동합니다.");
    }

    // 3,
    public void disConnect(){
        System.out.println("FTP 연결을 종료합니다.");
    }

}
