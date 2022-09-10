package org.chapter7.ex.innerEx;

class Outer2 {

    class InstatnceInner {
        int iv = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    void myMethod() {
        class LocalInner {
            int iv = 400;
        }
    }
}

public class Ex7_15 {
    // 내부 클래스로 선언해서는 안되는 클래스를 내부 클래스로 선언했다는 의미
    // 참고만
    public static void main(String[] args) {
        // 인스턴스 클래스의 인스턴스를 생성하려면
        // -> 외부 클래스의 인스턴스를 먼저 생성해야함
        Outer2 oc = new Outer2();
        Outer2.InstatnceInner ii = oc.new InstatnceInner();

        System.out.println("ii.iv = " + ii.iv);
        System.out.println("Outer2.StaticInner.cv = " + Outer2.StaticInner.cv);

        // 스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성할 필요 X
        Outer2.StaticInner si = new Outer2.StaticInner();
        System.out.println("si.iv = " + si.iv);

    }

}
