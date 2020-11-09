package hello.core.singleton;

public class StateFulService {

    private int price;

    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        //사용자 A가 주문하고 조회하는 사이에 사용자 B가 끼어듬.
//        this.price = price ---> 공유변수를 쓰는건 정말 안좋은 싱글톤 패턴!
        return price;
    }

    public int getPrice(){
        return price;
    }
}
