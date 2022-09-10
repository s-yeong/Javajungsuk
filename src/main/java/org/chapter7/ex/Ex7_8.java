package org.chapter7.ex;

/*
    매개변수의 다형성
 */

/*
    참조변수 배열로 처리
    Product p[] = new Product[2]
    p[0] = new Tv();
    p[1] = new Computer();
    조상 타입의 참조변수 배열을 사용하면, 공통의 조상을 가진 서로 다른 종류의 객체를 배열로 묶어서 다룰 수 있다.

 */

class Product {
    int price;
    int bonusPoint;
    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv1 extends Product {
    Tv1() {
        // 조상클래스의 생성자 Product(int price) 호출
        super(100);
    }
    
    public String toString() { // Object 클래스의 toString()을 오버라이딩함
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }
    public String toString() { return "Audio"; }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    Product[] cart = new Product[10]; // 구입한 제품을 저장하기 위한 배열(카트)
    // -> 조상타입의 참조변수로 자손타입의 객체를 참조하는 것이 가능하니까
    int i = 0;
    
    void buy(Product p) {   // 메서드의 매개변수에 다형성 적용 -> 하나의 메서드로 간단히 처리
        // Product, Computer 처리 가능
        // 메서드의 매개변수로 Product클래스의 자손타입의 참조변수면 어느 것이나 매개변수로 받아들일 수 있음
        if(money < p.price) {
            System.out.println("잔액 부족");
            return;
        }
        
        money -= p.price;
        bonusPoint += p.bonusPoint;

        cart[i++] = p;  // 제품을 Product[] cart에 저장

        System.out.println(p + " 구입 완료");
        // 참조변수 + 문자열 -> 참조변수.toString() + 문자열로 처리된다!
    }
    void summary() {
        int sum = 0;
        String itemList ="";

        for(int i=0; i<cart.length; i++) {
            if(cart[i]==null) break;
            sum += cart[i].price;
            itemList += (i==0)? "" + cart[i] : ", " + cart[i];
        }
        System.out.println("sum = " + sum);
        System.out.println("itemList = " + itemList);

    }
} // 다른 제품 클래스를 추가할 때 Product 클래스를 상속받기만 하면 매개변수로 받아들여질 수 있음



public class Ex7_8 {

    public static void main(String[] args) {
        Buyer b = new Buyer();
        
        b.buy(new Tv1());
        // Product p = new Tv1();
        b.buy(new Computer());
        // Product p = new Computer();
        // => 조상 타입의 참조 변수에 자손 인스턴스 생성
        b.buy(new Audio());
        b.summary();
        System.out.println("b.money = " + b.money);
        System.out.println("b.bonusPoint = " + b.bonusPoint);
    }
}
