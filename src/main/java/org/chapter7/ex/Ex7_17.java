package org.chapter7.ex;

/*
    익명 클래스
    다른 내부 클래스들과 달리 이름이 없다.
    클래스의 선언과 객체의 생성을 동시에 하기에 단 한번만 사용될 수 있고
    오직 하나의 객체만을 생성할 수 있는 일회용 클래스이다.
    
 */
public class Ex7_17 {
    Object iv = new Object() {  // 익명 클래스
        void method(){}
    };

    static Object cv = new Object() {   // 익명 클래스
        void method() {}
    };
    
    void myMethod() {
        Object lv = new Object() {  // 익명 클래스
            void method() {}
        };
    }
}
