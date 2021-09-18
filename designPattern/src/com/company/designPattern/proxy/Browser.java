package com.company.designPattern.proxy;

// Chrome과 같은 Browser가 있어야한다. 여기서는 그냥 Browser라고 이름 짓겠다.
public class Browser implements IBrowser{

    private String url;

    public Browser(String url){
        this.url=url;
    }

    @Override
    public Html show() {
        System.out.println("browser loading html from : "+url);
        return new Html(url);
    }
}
