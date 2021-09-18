package com.company.designPattern.facade;

// 파일을 만들 때에도 어떠한 파일을 만들것인지 파일 이름을 알아야한다.
public class Writer {
    private String fileName;

    public Writer(String fileName){
        this.fileName = fileName;
    }

    // 제공하는 3가지 메소드가 있다.
    // 1. 파일에 연결
    public void fileConnect(){
        String msg = String.format("Writer %s로 연결합니다.",fileName);
        System.out.println(msg);
    }

    // 2. 파일하고 연결 끊기
    public void fileDisconnect(){
        String msg = String.format("Writer %s로 연결 종료합니다.",fileName);
        System.out.println(msg);
    }

    // 3. 파일쓰기를 한다.
    public void write(){
        String msg = String.format("Writer %s로 파일 쓰기를 합니다.",fileName);
        System.out.println(msg);
    }

}
