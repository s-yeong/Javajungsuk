package org.chapter7.ex;

/*
    참조변수 super
    자손 클래스에서 조상클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수
    상속받은 멤버와 자신의 멤버와 이름이 같으면 super를 붙여 구별

    모든 인스턴스 메서드에는 this와 super가 지역변수로 존재
    이 들에는 자신시 속한 인스턴스의 주소가 자동으로 저장됨

    - 조상의 생성자 호출하는데 사용

 */
public class Ex7_2 {
    public static void main(String[] args) {

        Child c = new Child();
        c.method();
    }
}

class Parent {
    int x = 10; // super.x
}

class Child extends Parent {
    int x = 20; // this.x
    // x를 상속받는데, 자신의 멤버인 x와 이름이 같아서 구분할 방법이 필요 => super
    void method() {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}

class Point2 {
    int x;
    int y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D2 extends Point2 {

    int z;

    // 클래스 자신에 선언된 변수는 자신의 생성자가 초기화를 책임지도록 작성
    Point3D2(int x, int y, int z) {
        super(x,y); // 조상 클래스의 생성자 Point2(int x, int y) 호출
        this.z = z; // 자신의 멤버를 초기화
    }

}
