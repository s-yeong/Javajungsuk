package org.chapter6.ex;

/*
    변수의 종류 : 클래스 변수, 인스턴스 변수, 지역변수
    중요한 요소 - 변수의 선언 위치
    멤버변수를 제외한 나머지 변수 -> 모두 지역변수
    클래스 영역에 선언된 변수를 멤버 변수라 한다

    인스턴스 변수(클래스 영역) -> 인스턴스가 생성되었을 때
    클래스 변수(클래스 영역) -> 클래스가 메모리에 올라갈 때
    지역 변수(이외 영역) -> 변수 선언문이 수행되었을 때

    *인스턴스 변수*
    인스턴스 변수의 값을 읽어 오거나 저장하려면 먼저 인스턴스를 생성해야함
    인스턴스마다 별도의 저장공간을 가지므로 서로 다른 값을 가질 수 있다
    -> 인스턴스 마다 고유한 상태를 유지해야하는 속성의 경우 선언

    *클래스 변수*
    인스턴스마다 독립적인 저장곤간을 갖는 인스턴스 변수와는 달리,
    클래스 변수는 모든 인스턴스가 공통된 저장공간(변수)를 공유한다
    -> 한 클래스의 모든 인스턴스들이 "공통적인 값"을 유지해야하는 속성의 경우 선언

    인스턴스 변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만,
    클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
 */

public class Ex6_3 {

    public static void main(String[] args) {

        System.out.println("Car.width = " + Card.width);
        // 클래스 변수(static 변수)는 객체생성 없이 직접 사용 가능하다

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Space";
        c2.number = 4;

        c1.width = 50;  // c2의 width도 바뀜 (공유하기 때문)
        System.out.println("c2.width = " + c2.width);
        // Card.width, c1.width, c2.width 모두 같은 저장공간 참조함 => 같은 값

        // ***** 되도록 c1.width 보다는 Card.with 라고 쓰자 *****
    }


}

class Card {    // --> 클래스영역

    String kind; // 인스턴스 변수 - 각 카드마다 다르니까
    int number;
    static int width = 100; // 클래스 변수(static 변수, 공유변수) - 각 카드마다 일정하니까
    static int height = 250;

    void method() { // --> 메서드영역
        int lv = 0; // 지역변수
    }


}
