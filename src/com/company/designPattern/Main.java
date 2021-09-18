package com.company.designPattern;

import com.company.designPattern.adapter.*;
import com.company.designPattern.aop.AopBrowser;
import com.company.designPattern.decorator.*;
import com.company.designPattern.facade.Ftp;
import com.company.designPattern.facade.Reader;
import com.company.designPattern.facade.SftpClient;
import com.company.designPattern.facade.Writer;
import com.company.designPattern.observer.Button;
import com.company.designPattern.observer.IButtonListener;
import com.company.designPattern.proxy.Browser;
import com.company.designPattern.proxy.BrowserProxy;
import com.company.designPattern.proxy.IBrowser;
import com.company.designPattern.singleton.AClazz;
import com.company.designPattern.singleton.BClazz;
import com.company.designPattern.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

//        // 1. singleton pattern : 어떤 클래스(객체)가 유일하게 1개만 존재할 때 사용한다.
//        // ex ) 프로그래밍에서 TCP Socket통신에서 서버와 연결된 connect 객체에 주로 사용한다. Socket자체는 한개만 사용한다.
//        // ex ) 스프링에서 빈이라고 부르는 객체(클래스)는 기본적으로 싱글톤으로 관리된다.
//        // - 디폴트 생성자를 private으로 막아버린다.
//        // - getInstance라는 method를 통해서 생성되어 있는 객체들을 가지고 온다. 이때 객체가 없는 경우, 객체를 새로 생성해준다.
//        //      : 그 결과, 어떠한 클래스에서 getInstance를 하였을 때 동일한 객체를 얻을 수 있다.
//        AClazz aClazz = new AClazz();
//        BClazz bClazz = new BClazz();
//
//        SocketClient aClient = aClazz.getSocketClient();
//        SocketClient bClient = bClazz.getSocketClient();
//
//        System.out.println("두개의 객체가 동일한가?");
//        System.out.println(aClient.equals(bClient));    // 객체가 동일한지 체크하기 위해서 equals() 사용한다.


//        // 2. adapter pattern
//        // - adapter : 실생활에서는 100v를 200v로 변경해주거나, 그 반대로 해주는 흔히 돼지코라고 불리는 변환기를 예로 들 수 있다.
//        // - 호환성이 없는 기존 클래스의 중간에 인터페이스를 둔다. 이 인터페이스를 변환하여 재사용 할 수 있도록 한다.
//        // - SOLID중에서 개방폐쇄 원칙 (OCP)를 따른다.
//
//        // 110V짜리 HairDryer 켜기
//        HairDryer hairDryer = new HairDryer();
//        connect(hairDryer);
//
//        // 220V짜리 Cleaner 켜기
//        Cleaner cleaner = new Cleaner();
//        //connect(cleaner);     // error
//        Electronic110V cleanerAdapter = new SocketAdapter(cleaner);
//        connect(cleanerAdapter);
//
//        // 220V짜리 AirConditioner 켜기
//        AirConditioner airConditioner = new AirConditioner();
//        //connect(airConditioner);    // error
//        Electronic110V airAdapter = new SocketAdapter(airConditioner);
//        connect(airAdapter);


//        // 3. proxy pattern
//        // : proxy는 대리인이라는 뜻으로써, 뭔가를 대신해서 처리하는 것
//        // : proxy class를 통해서 대신 전달하는 형태로 설계되며, 실제 client는 proxy로부터 결과를 받는다.
//        // : cache의 기능으로도 활용이 가능하다.
//        // : SOLID중에서 개방폐쇄 원칙(OCP)와 의존 역전 원칙(DIP)를 따른다.
//        // : 실제로 스프링에서는 AOP에서 proxy pattern을 사용히고 있다.
//
////        // - proxy pattern을 적용 안한 코드
////        Browser browser = new Browser("www.naver.com");
////        browser.show();
////        // 여러번 페이지를 본다고 했을 때, 매번 로딩이 일어난다.(매번 네이버로부터 받아온다.) -> 현재는 캐시기능이 없다.
////        browser.show();
////        browser.show();
////        browser.show();
////
////        System.out.println();
////
////        // proxy pattern을 적용하여 cache의 기능을 넣어보겠다.
////        // - proxy pattern을 적용한 코드 : 로딩은 한번만 한다.
////        IBrowser browser1 =  new BrowserProxy("www.naver.com");
////        browser1.show();
////        browser1.show();
////        browser1.show();
////        browser1.show();
//
//        // +)AOP : 특정 메소드의 전,후에 기능을 일괄적으로 넣을 수 있다. ex) 시간측정
//        //       : proxy pattern을 사용하고 있다.
//        // 시간측정을 하기위해서는 동시성 때문에 Atomic을 사용해야한다.
//        AtomicLong start = new AtomicLong();       // 시작 시간
//        AtomicLong end = new AtomicLong();         // 총 걸린 시
//
//        IBrowser aopBrowser = new AopBrowser("www.naver.com",
//                ()->{
//                    System.out.println("before");
//                    start.set(System.currentTimeMillis());  // start에다가 set메소드로 현재 Millis을 넣어준다.
//                },
//                ()->{
//                    long now = System.currentTimeMillis();  // 끝난 시간
//                    end.set(now-start.get());
//                }
//                );
//
//        aopBrowser.show();
//        System.out.println("loading time : "+end.get());
//
//        aopBrowser.show();  // 이 코드는 위의 코드와 출력결과가 다르다. loading time이 0초가 걸린다. cache 사용하기 때문에!
//        System.out.println("loading time : "+end.get());

//        // 4. decorator pattern
//        // : 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태로 꾸밀 때 사용한다.
//        // : 확장이 필요한 경우 상속의 대안으로도 활용한다.
//        // : SOLID중에서 개방폐쇄 원칙(OCP)과 의존 역전 원칙(DIP)를 따른다.
//        // ex) 커피원액 -> 아메리카노, 라떼 / 케이크 -> 초코케이크, 딸기케이크, 과일케이크
//        //     : 원본을 유지하되, 뭘 첨가하는지에 따라서 다른 형태로 확장되는 것이다.
//        ICar audi = new Audi(1000);
//        audi.showPrice();
//
//        // a3
//        ICar audi3 = new A3(audi, "A3");
//        audi3.showPrice();
//
//        // a4
//        ICar audi4 = new A4(audi, "A4");
//        audi4.showPrice();
//
//        // a5
//        ICar audi5 = new A5(audi, "A4");
//        audi5.showPrice();

//        // 5. observer pattern (관찰자 패턴)
//        // : 변화가 일어났을 때, 미리 등록된 다른 클래스에 통보해주는 패턴을 구현한 것이다.
//        // : 많이 보이는 곳은 event listener에서 해당 패턴을 사용하고 있다. 특정한 event가 발생하면 listener를 통해 event가 전달된다.
//        Button button = new Button("버튼");
//
//        button.addListener(new IButtonListener() {  // 익명 클래스로 전달받아서 넣어보겠다.
//            @Override
//            public void clickEvent(String event) {
//                System.out.println(event);
//            }
//        });
//
//        button.click("메시지 전달 : click1");
//        button.click("메시지 전달 : click2");
//        button.click("메시지 전달 : click3");
//        button.click("메시지 전달 : click4");

        // 6. facade pattern
        // : facade는 건물의 앞쪽 정면이라는 뜻을 가진다. 건물의 뒷쪽에는 뭐가 있는지 모른다.
        // : 여러 개의 객체와 실제 사용하는 서브 객체의 사이에 복잡한 의존관계가 있을 때, 중간에 facade라는 객체를 두고, 여기서 제공하는 interface만을 활용하여 기능을 사용하는 방식이다.
        // : facade는 자신이 가지고 있는 각 클래스의 기능을 명확히 알아야 한다.
        // : facade는 어떠한 인터페이스를 제공하는지도 정확히 알아야한다.
        // : 여러개의 객체를 합쳐서 특정한 기능을 만들 때 사용한다.

        // - facade 적용 안된 것, 개별적으로 다 만들어서 코딩을 진행해야하는 상황이다. 클라이언트가 의존성을 가지고 다 만들고 있다.
        Ftp ftpClient = new Ftp("www.foo.co.kr",22,"/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        System.out.println();

        // - facade객체 만들어서 적용 한 것.
        // : facade pattern을 적용시키면 새로운 객체가 만들어지고,
        //   이 객체를 통해 안에 있는 복잡한 의존성을 가진 것들을 새로운 인터페이스 형태로 제공된다.
        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();

    }

//    // 2. adapter pattern
//    // 110V짜리 콘센트
//    public static void connect(Electronic110V electronic110V){
//        electronic110V.powerOn();
//    }

}
