public class DollarCalculator implements ICalculator{   // 구현체 2

    private int price=1;    // 기본 환율을 1이라고 하자

//    public void init(){ // 달러의 시세 가치를 가져오는 함수. connect()를 통해서 현재 환율을 가져온다.
//        this.price = connect();
//    }
//
//    public int connect(){   // 예)네이버에 접근해서 현재 환율을 가져오는 과정이라고 하자
//        // naver
//        // kakao
//        return 1100;
//    }
    // => 하지만 계산기는 계산을 해야지, 갑자기 계산기 외의 다른 기능(현재 환율을 가져오는 기능)을 수행하면 안된다.
    // 그래서 connect() 함수 구현부분을 분리시키겠다.

    private MarketApi marketApi;

    public DollarCalculator(MarketApi marketApi){
        this.marketApi = marketApi;
    }

    public void init(){
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x-y;
    }
}
