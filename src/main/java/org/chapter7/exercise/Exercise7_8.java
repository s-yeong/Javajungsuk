package org.chapter7.exercise;

class Outer {
    int value = 10;
    class Inner {
        int iv = 100;
    }
    static class StaticInner {
        int iv= 200;
    }

    class Inner2 {
        int value = 20;
        void method1() {
            int value = 30;
            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer.this.value);
            // 외부 클래스의 인스턴스 변수는 내부 클래스에서
            // "외부클래스.this.변수이름" 으로 접근한다
        }
    }
}

public class Exercise7_8 {
    public static void main(String[] args) {

        // 내부 클래스(인스턴스 클래스)의 인스턴스를 생성하기 위해서는
        // 먼저 외부클래스의 인스턴스를 생성해야함
        // (인스턴스 클래스는 외부 클래스의 인스턴스 변수처럼 외부 클래스 인스턴스가 생성되어야 쓸 수 있다)
        Outer o = new Outer();
        Outer.Inner i = o.new Inner();
        System.out.println(i.iv);

        // 스태틱 클래스는 인스턴스 클래스와 달리 외부 클래스의 인스턴스를 생성하지 않고 사용가능
        // 마치 static 멤버를 인스턴스 생성없이 사용할 수 있는 것과 같음
        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println(si.iv);

        Outer o2 = new Outer();
        Outer.Inner2 inner2 = o2.new Inner2();
        inner2.method1();

    }

}
