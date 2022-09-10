package org.chapter7.ex.innerEx;

public class Ex7_13 {

    class InstanceInner {}
    // 인스턴스 멤버 -> 같은 클래스에 있는 인스턴스 멤버와 static 멤버 모두 직접 호출이 가능
    // 인스턴스 클래스 - 외부 클래스의 인스턴스 멤버를 객체생성 없이 사용 가능
    static class StaticInner {}
    // static 멤버 -> 인스턴스 멤버 직접 호출 X
    // 스태틱 클래스 - 외부 클래스의 인스턴스 멤버를 객체생성 없이 사용 불가

    // 인스턴스 멤버 간에는 서로 직접 접근 가능
    InstanceInner iv = new InstanceInner();
    // static 멤버 간에는 서로 직접 접근 가능
    static StaticInner cv = new StaticInner();

    static void staticMethod() {
        // static 멤버는 인스턴스 멤버에 직접 접근할 수 없다.
//        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 굳이 접근하려면 아래와 같이 객체를 생성
        Ex7_13 outer = new Ex7_13();
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void instanceMethod() {
        // 인스턴스 메서드에서는 인스턴스 멤버와 static 멤버 모두 접근 가능
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근 할 수 없음
//        LocalInner lv = new LocalInner();
    }

    void myMethod() {
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }
}
