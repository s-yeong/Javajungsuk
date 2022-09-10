package org.chapter6.ex;

/*
    변수의 초기화
    변수를 선언하고 처음으로 값을 저장하는 것

    멤버변수(클래스 변수, 인스턴스 변수)와 배열의 초기화는 선택이지만, - 자료형에 맞는 기본값으로 초기화
    "지역변수의 초기화"는 필수이다

    멤버변수의 초기화
    1. 클래스 변수 초기화 -> 인스턴스 변수 초기화
    2. 타입의 기본값으로 자동 초기화 -> 명시적 초기화 -> 초기화 블럭, 생성자

    명시적 초기화
    class Car {
        int door = 4;   // 기본형 변수의 초기화
        Engine e = new Engine();    // 참조형 변수의 초기화
    }

    초기화 블럭
    클래스 초기화 블럭 - 클래스 변수의 복잡한 초기화에 사용
    인스턴스 초기화 블럭 - 인스턴스 변수의 복잡한 초기화에 사용
 */


public class Ex6_14 {
    static {
        System.out.println("static { }");   // 클래스 초기화 블럭
    }   // 메모리에 로딩될 떄 한 번만 수행 (가장 먼저 수행)

    {
        System.out.println("{ }");  // 인스턴스 초기화 블럭
    }   // 인스턴스가 생성될 때 마다 수행

    static int[] arr = new int[10]; // 명시적 초기화
    static {
        for(int i = 0; i <arr.length; i++) {
            arr[i] = (int)(Math.random()*10) + 1;
        }
    }
    public Ex6_14() {
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("Ex6_14 bt = new Ex6_14();");
        Ex6_14 bt = new Ex6_14();

        System.out.println("Ex6_14 bt2 = new Ex6_14();");
        Ex6_14 bt2 = new Ex6_14();
    
        // 클래스 초기화 블럭 -> main 메서드 -> 인스턴스 생성 -> 인스턴스 초기화 블럭 -. 생성자 수행

        for(int i = 0; i<arr.length; i++) {
            System.out.println("arr["+i+"] = " + arr[i]);
        }
    }
}
