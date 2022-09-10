package org.chapter7.ex;

/*
    상속
    기존의 클래스를 재사용하여 새로운 클래스를 작성
    - 자손 클래스는 조상 클래스의 모든 멤버를 상속받는다. (생성자와 초기화 블럭은 상속되지 않는다.)
    - 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.
    - 단일 상속만 허용된다.

    클래스 간의 관계 - 포함관계
    "한 클래스의 멤버변수"로 "다른 클래스 타입의 참조변수"를 선언

    포함관계, 상속관계 언제?
    ~은 ~ 이다 => 상속관계
    ~은 ~을 가지고 있다 => 포함관계
 */

// 포함관계 -> 원은 점을 가지고 있다.
class Point {
    int x;
    int y;
    String getLocation() {
        return "x:"+x+" y:"+y;
    }
}
class Circle {
    Point p = new Point(); // 다른 클래스를 멤버변수로 선언하여 포함시킴
    int r;
}

/*
    Object 클래스 - 모든 클래스의 조상 (최상위)
    ex) class Tv { => extends Object가 자동 추가됨
 */

/*
    오버라이딩(overriding)
    조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것(change, modify)
    -> 자손 클래스 자신에 맞게 변경해야하는 경우가 많음
    <조건>
    1. 선언부가 조상 클래스의 메서드와 일치해야한다.
    2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
    ex) 조상 protected,   자손 protected나 public이어야 함
    3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.

    오버로딩
    기존에 없는 새로운 메서드를 정의하는 것(new)
    - 같은 이름의 메서드 여러개를 가지면서, 매개변수의 유형과 개수가 다른 것
    ex) void childMethod(),     void childMethod(int i) -> 오버로딩

 */

class Point3D extends Point {
    int z;
    String getLocation() {  // 오버라이딩
        return "x:"+x+" y:"+y + " z:" + z;
    }
}

public class Ex7_ {

}


