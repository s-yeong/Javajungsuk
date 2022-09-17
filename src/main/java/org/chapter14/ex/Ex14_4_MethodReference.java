package org.chapter14.ex;

import java.util.function.Function;

/**
 * 메서드 참조
 * 클래스 이름 :: 메서드 이름
 * (이해안가면 메서드 참조를 람다식으로 바꾸는 연습 하기)
 */
/*
    메서드 참조 (람다식을 더 간단히)
    람다식이 하나의 메서드만 호출하는 경우,
    메서드 참조 방법으로 람다식을 간략히 할 수있다.

    ex) 문자열을 정수로 변환하는 람다식
    Function<String, Integer> f = (String s) -> Integer.parseInt(s);
    => 메서드 참조로 변경
    Function<String, Integer> f2 = Integer::parseInt;

    하나의 메서드만 호출하는 람다식은
    => "클래스이름::메서드이름" 또는 "참조변수::메서드이름"으로 바꿀 수 있다!!

    static 메서드 참조
    람다 - (x) -> ClassName.method(x)
    메서드 참조 - ClasName::method

    인스턴스메서드 참조
    람다 -(obj, x) -> obj.method(x)
    메서드 참조 - ClassName::method

    특정 객체 인스턴스 메서드 참조 (거의 안씀 잊어도 됨)
    람다 - (x) -> obj.method(x)
    메서드 참조 -> obj::method
 */

/*
    생성자의 메서드 참조
    생성자를 호출하는 람다식도 메서드 참조로 변환할 수 있다

    Supplier<MyClass> s = () -> new MyClass();
    Supplier<MyClass> s = MyClass::new;

    Function<Integer, MyClass> f = (i) -> new MyClass(i);
    Function<Integer, MyClass> f = MyClass::new;

    BiFunction<Integer, String, MyClass> f = (i, s) -> new MyClass(i,j);
    BiFunction<Integer, String, MyClass> f = MyClass::new;

    배열 생성 (많이 씀)
    Function<Integer, int[]> f = x -> new int[x];
    Function<Integer, int[]> f = int[]::new;
 */

// 메서드 참조는 람다식을 마치 static 변수처럼 다룰 수 있게 해준다!!! (유용함)
class Ex14_4_MethodReference {
    public static void main(String[] args) {

        // ex) 문자열을 정수로 변환하는 람다식
        Function<String, Integer> f = s -> Integer.parseInt(s);
        // -> 메서드로 표현
//        Integer wrapper(String s) { // 메서드 이름은 의미 X
//            return Integer.parseInt(s);
//        }
        // 이 wrapper 메서드는 별로 하는일이 없음,
        // 그저 값을 받아서 Integer.parseInt()에 넘겨주는 일
        // => 메서드 벗겨내고 Integer.parseInt()를 직접 호출하자!!

        // 메서드 참조
        Function<String, Integer> f2 = Integer::parseInt;   // static 메서드 참조
        // 람다식 일부 생략되어도 컴파일러는 생략된 부분 parseInt 메서드의 선언부나
        // Function 인터페이스에 지정된 지네릭 타입으로부터 쉽게 알아낼 수 있음
    }

}
