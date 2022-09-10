package org.chapter6.ex;


/*
    하나의 소스파일에 하나의 클래스만을 정의하는 것이 보통
    But, 하나의 소스파일에 둘 이상의 클래스를 정의하는 것도 가능!
    주의!! 소스파일의 이름은 public class 이름과 일치해야함(public class 없는 경우 상관X)
 */


// 하나의 소스파일에 둘 이상의 public class가 존재할 수 없다
// 소스파일(.java)와 달리 클래스 파일(.class)는 클래스마다 하나씩 만들어진다!
public class Ex6_1 {

    public static void main(String[] args) {

        Tv t;   // Tv 인스턴스를 참조하기 위한 변수 t 선언 (클래스의 객체를 참조하기 위한 참조변수 선언)
        // -> Tv 클래스 타입의 참조변수 t 선언 -> 메모리에 참조변수 t를 위한 공간 마련

        t = new Tv(); // Tv 인스턴스 생성 (클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장)
        // Tv 클래스의 인스턴스가 메모리의 빈 공간에 생성
        // 멤버변수는 각 자료형에 해당하는 기본값으로 초기화
        // 생성된 객체의 주소값이 참조변수 t에 저장 -> 참조변수 t를 통해 인스턴스에 접근 가능
        // 인스턴스를 다루기 위해서는 참조변수가 반드시 필요!!    참조변수의 타입은 인스턴스 타입과 일치해야함

        t.channel = 7;
        // 참조변수 t에 저장된 주소에 있는 인스턴스의 멤버변수 channel에 7을 저장
        t.channelDown();
        System.out.println("현재 채널 : " + t.channel);

        /*
            객체 배열
            객체 배열 안에 객체가 저장되는 것은 아니고, 객체의 "주소"가 저장된다.
            객체 배열 => 참조변수들을 하나로 묶은 참조변수 배열
         */

        Tv[] tvArr = new Tv[3];
        // 객체 배열 생성 -> 각 요소는 참조변수의 기본값인 null로 자동 초기화
        // => 3개의 객체의 주소를 저장할 수 있다!

        // 객체 생성해서 배열의 각 요소에 저장
        tvArr[0] = new Tv();
        tvArr[1] = new Tv();
        tvArr[2] = new Tv();

    }
}

class Tv {

    // Tv의 속성(멤버변수)
    String color;
    boolean power;
    int channel;

    // Tv의 기능(메서드)
    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }

}
