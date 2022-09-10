package org.chapter6.ex;

/*
    생성자
    인스턴스가 생성될 떄 호출되는 "인스턴스 초기화 메서드" - 단순히 인스턴스 변수들의 초기화에 사용되는 조금 특별한 메서드
    1. 생성자 이름은 클래스의 이름과 같아야 한다.
    2. 생성자는 리턴 값이 없다.
    - 기본 생성자가 컴파일러에 의해서 추가되는 경우는 클래스에 정의된 생성자가 하나도 없을 때 뿐이다.

   생성자 간에도 서로 호출이 가능하다
   - 생성자의 이름으로 클래스이름 대신 this를 사용
   - 한 생성자에서 다른 생성자를 호출할 때는 반드시 "첫 줄에서만" 호출이 가능

   this
   참조변수로 인스턴스 자신을 가리킨다. -> this로 인스턴스 변수에 접근할 수 있다.
   - 인스턴스의 주소가 저장되어 있다.(모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재)
   - static 메서드에서는 사용 불가능
   this - 참조변수,     this() - 생성자

 */
class Car2 {
    String color;
    String gearType;
    int door;

    Car2() {
        // 첫 줄에서 호출
        this("white", "auto", 4);   // Car2(String color, String gearType, int door) 호출
        /*
        color = "white";
        gearType = "auto";
        door = 4;
         */
    }
    
    Car2(String color) {
        // 첫 줄에서 호출
        this(color, "auto" , 4);    // Car2(String color, String gearType, int door) 호출
    }
    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}

public class Ex6_11 {
    public static void main(String[] args) {

    }
}
