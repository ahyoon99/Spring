public class Main {

    public static void main(String args[]){
        System.out.println("Hello JUnit");

        // 우리가 원래 테스트하던 방법!!
        Calculator calculator = new Calculator(new KrwCalculator());
        System.out.println(calculator.sum(10,10));

        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();
        Calculator calculator2 = new Calculator(dollarCalculator);  // 달러 계산기를 사용하기 위해 dollarCalculator를 주입해준다.
        System.out.println(calculator2.sum(10,10));

    }
}
