package org.chapter7.ex.innerEx;

/*
    내부 클래스
    클래스 내에 선언된 클래스
    클래스에 다른 클래스를 선언하는 이유는 서로 긴밀한 관계가 있기 때문

    내부 클래스 장점
    - 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
    - 코드의 복잡성을 줄일 수 있다(캡슐화)
    
    내부 클래스는 외부 클래스를 제외하고는 다른 클래스에서 잘 사용되지 않는는 것이어야함
    특징은 변수와 비슷하다.

    종류 - 인스턴스 클래스, 스태틱 클래스, 지역 클래스, 익명 클래스
    1. 인스턴스 클래스 : 외부 클래스의 멤버변수 선언위치에 선언(인스턴스 멤버 처럼 다뤄짐)
    주로 외부 클래스의 인스턴스 멤버들과 관련된 작업에 사용될 목적으로 선언
    2. 스태틱 클래스 : 외부 클래스의 멤버변수 선언위치에 선언(static 멤버처럼 다뤄짐)
    주로 외부 클래스의 static 멤버, 특히 static 메서드에서 사용될 목적으로 선언
    3. 지역 클래스 : 외부 클래스의 메서드나 초기화 블럭 안에 선언, 선언된 영역 내부에서만 사용가능
    4. 익명 클래스 : 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용)

    - 내부 클래스 중 스태틱 클래스만 static 멤버를 가질 수 있다. (상수는 가능하다)
 */

public class Ex7_12 {
    class InstanceInner {   // 인스턴스 클래스
        int iv = 100;
//        static int cv = 100;  // static 변수 선언 불가
        final static int CONST = 100;   // 상수는 가능
    }
    static class StaticInner { // 스태틱 클래스
        int iv = 200;
        static int cv = 200;    // static 클래스만 static 멤버를 정의할 수 있다.
    }

    void myMethod() {
        class LocalInner {  // 지역 클래스
            int iv = 300;
            final static int CONST = 300;
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
    }

}
