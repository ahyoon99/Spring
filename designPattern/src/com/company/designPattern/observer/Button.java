package com.company.designPattern.observer;

public class Button {

    private String name;
    private IButtonListener buttonListener;

    public Button(String name){
        this.name = name;
    }

    public void click(String message) {
        // listener를 통해 message 전달해준다.
        // 여기서 특정 event는 message이다.
        buttonListener.clickEvent(message);
    }

    public void addListener(IButtonListener buttonListener){
        this.buttonListener = buttonListener;
    }
}
