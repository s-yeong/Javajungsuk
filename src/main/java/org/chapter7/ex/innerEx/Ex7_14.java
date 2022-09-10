package org.chapter7.ex.innerEx;

class Outer {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv;  // 외부 클래스의 private 멤버도 접근 가능 !
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근 X
//        int siv = outerIv;
        static int scv = outerCv;
    }
    void myMethod() {
        int lv = 0;
        final int LV = 0; // final 생략 가능
        
        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;

            // 지역변수는 final이 붙은 변수(상수)만 접근 가능
            // -> 메서드가 수행을 마쳐서 지역변수가 소멸된 시점에도,
            // 지역 클래스의 인스턴스가 소멸된 지역변수를 참조하려는 경우가 발생할 수 있음
//            int liv3 = lv;
            int liv4 = LV;
            
        }
        
    }
}
public class Ex7_14 {
}
