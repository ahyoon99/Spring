package com.company.IOC_DI;

public class Encoder {

    private IEncoder iEncoder;

    // 3) 코드
    public Encoder(){
        this.iEncoder = new Base64Encoder();
        //this.iEncoder = new UrlEncoder();
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }

}
