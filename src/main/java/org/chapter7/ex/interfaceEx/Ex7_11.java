package org.chapter7.ex.interfaceEx;

/*
    원래는 인터페이스 추상 메서드만 선언할 수 있는데, 디폴트 메서드와 static 메서드도 추가할 수 있게됨
    인터페이스 메서드 변경 -> 골치아픔 -> 디폴트 메서드 고안

    디폴프 메서드
    추상 메서드의 기본적인 구현을 제공하는 메서드
    - 추상 메서드가 아니기 때문에 디폴트 메서드가 새로 추가되어도 해당 인터페이스를 구현한 클래스를 변경할 필요 없음
    - 앞에 default 붙여야함, 몸통 {} 있어야함, 접근 제어자 public(생략 가능)

    interface MyInterface {
       default void newMethod() {}
    }

    1. 여러 인터페이스의 디폴트 메서드 간 충돌
    -> 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩해야 한다.
    2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
    - 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.

 */

public class Ex7_11 {
    public static void main(String[] args) {

        Child3 c = new Child3();
        c.method1();
        c.method2();
        MyInterface.staticMethod();
        MyInterface2.staticMethod();
    }
}

class Child3 extends Parent3 implements MyInterface, MyInterface2 {

    public void method1() {
        // MyInterface, MyInterface2에서 디폴트 메서드 간 충돌
        System.out.println("Child3.method1"); // 오버라이딩
        
        // method2 MyInterface 디폴트 메서드와 조상 클래스 메서드와 충돌
        // 조상 클래스의 메서드 상속
    }
}

class Parent3 {
    public void method2() {
        System.out.println("Parent3.method2");
    }
}

interface MyInterface {
    default void method1() {
        System.out.println("MyInterface.method1");
    }
    default void method2() { // default 메서드이기 때문에 구현 클래스에서 구현할 필요X
        System.out.println("MyInterface.method2");
    }
    static void staticMethod() {
        System.out.println("MyInterface.staticMethod");
    }
}

interface MyInterface2 {
    default void method1() {
        System.out.println("MyInterface2.method1");
    }
    static void staticMethod() {
        System.out.println("MyInterface2.staticMethod");
    }
}
