package com.company.designPattern.facade;

// 파일에서 읽어오는 fileReader이다. 이때 읽어오려면 file의 이름을 알아야한다.
public class Reader {

    private String fileName;

    public Reader(String fileName){
        this.fileName = fileName;
    }

    // 제공하는 3가지 메소드가 있다.
    // 1. 파일에 연결
    public void fileConnect(){
        String msg = String.format("Reader %s로 연결합니다.",fileName);
        System.out.println(msg);
    }

    // 2. 파일에서 내용을 읽어온다.
    public void fileRead(){
        String msg = String.format("Reader %s의 내용을 읽어옵니다.",fileName);
        System.out.println(msg);
    }

    // 3. 파일하고 연결 끊기
    public void fileDisconnect(){
        String msg = String.format("Reader %s로 연결 종료합니다.",fileName);
        System.out.println(msg);
    }


}
