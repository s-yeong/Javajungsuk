package org.chapter14.ex;
/*
    함수형 인터페이스
    단 하나의 추상 메서드만 선언된 인터페이스 (람다식과 인터페이스의 메서드가 1:1 연결)
    => 람다식을 다루기 위해 사용

    람다식을 참조변수로 다룰 수 있다는 것은 메서드를 통해 람다식을 주고받을 수 있다는 것을 의미
    => 변수처럼 메서드를 주고받는 것이 가능해짐
 */

@FunctionalInterface    // 함수형 인터페이스 애노테이션을 붙이면 올바르게 작성했는지 컴파일러가 확인해줌
interface MyFunction {
    // 단 하나의 추상 메서드!
    void run(); // pulibc abstract void run();
}

class Ex14_1_FunctionalInterface {

    // 함수형 인터페이스 타입의 매개변수
    static void execute(MyFunction f) { // 매개변수의 타입이 MyFunction인 메서드
        // => 매개변수로 "람다식" 을 받겠다
        f.run();    // 람다식을 호출 (MyFunction에 정의된 메서드 호출)
    }

    // 함수형 인터페이스 타입의 반환타입
    static MyFunction getMyFunction() { // 반환 타입이 MyFunction인 메서드
        // 람다식을 반환하겠다
        MyFunction f = () -> System.out.println("f3.run()");
        return f;

        // 한줄로 합치면
        // return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {

        // 1. 람다식으로 MyFunction의 run()을 구현
        // => 함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있음
        // 단, 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야함
        MyFunction f1 = () -> System.out.println("f1.run()");

        // 2. 익명클래스로 run()을 구현
        MyFunction f2 = new MyFunction() {  // 클래스의 선언, 생성 동시에
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);    // 람다식을 참조변수에 담고 참조변수를 넣어줌
        execute( () -> System.out.println("run()"));    // 람다식을 직접 넣어줌

    }


}
