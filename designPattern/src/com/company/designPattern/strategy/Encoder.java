package com.company.designPattern.strategy;

// encoder는 그때그때 마다 전략을 주입받아서 사용할 것이다.
public class Encoder {

    private EncodingStrategy encodingStrategy;

    public String getMessage(String message){
        return this.encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}
