package com.example.ioc_di_spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class Encoder {

    private IEncoder iEncoder;

    // 3) 코드
//    public Encoder(){
//        this.iEncoder = new Base64Encoder();
//        //this.iEncoder = new UrlEncoder();
//    }
//
//    public String encode(String message){
//        return iEncoder.encode(message);
//    }

    // 4) 코드
    public Encoder(IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }

}