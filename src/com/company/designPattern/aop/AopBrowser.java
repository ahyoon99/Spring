package com.company.designPattern.aop;

import com.company.designPattern.proxy.Html;
import com.company.designPattern.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;    // 앞에 실행시킬 메소드
    private Runnable after;     // 듸에 실행시킬 메소드

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    // +) Runnable : @FunctionalInterface이다.

    @Override
    public Html show() {
        before.run();

        if(html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : "+url);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();

        System.out.println("AopBrowser html cache : "+url);
        return html;
    }
}
