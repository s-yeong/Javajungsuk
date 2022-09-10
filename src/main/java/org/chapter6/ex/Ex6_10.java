package org.chapter6.ex;

/*
    오버로딩(overloading)
    한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것
    성립 방법
    1. 메서드 이름이 같아야함
    2. 매개변수의 개수 또는 타입이 달라야함 (int x, double y랑 double x, int y랑 구별함)
    3. 반환 타입은 관계 없음 - 매개변수에 의해서만 구별되므로
    ex) println
 */

public class Ex6_10 {
    public static void main(String[] args) {

        MyMath3 mm = new MyMath3();
        System.out.println(mm.add(3, 3));
    }


}

class MyMath3 {
    long a, b;

    int add(int a, int b) { return a + b; }
    long add(int a, long b) { return a + b; }
    long add(long a, int b) { return a + b; }
}
