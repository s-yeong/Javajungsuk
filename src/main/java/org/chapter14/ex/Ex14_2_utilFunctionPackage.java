package org.chapter14.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/*
    대부분의 메서드는 타입이 비슷함
    매개변수가 없거나, 한 개 또는 두개 ... 반환 값은 없거나 한 개

    java.util.function 패키지에
    일반적으로 "자주 쓰이는 형식의 메서드를 함수형 인터페이스"로 미리 정의해둠
    => 매번 새로운 함수형 인터페이스를 정의하지 말고, 가능하면 이 패키지의 인터페이스를 활용하자!
    => 그래야 함수형 인터페이스에 정의된 메서드 이름도 통일되고, 재사용성이나 유지보수 측면에서도 좋다.
    
    *** 기본적인 함수형 인터페이스 ***
    함수형 인터페이스          메서드                   설명
    java.lang.Runnable      void run()              매개변수도 없고, 반환값도 없음
    Supplier<T>             T get() => T            매개변수는 없고, 반환값만 있음
    Consumer<T>        T => void accept(T t)        <-> 매개변수만 있고, 반환값이 없음
    Function<T,R>      T => R apply(T t) => R       일반적인 함수, 하나의 매개변수를 받아 반환
    Predicate<T>       T => boolean test(T t) => boolean 조건식을 표현하는데 사용, 매개변수는 하나, 반환타입은 boolean
    - T는 Type, R은 Return Type 의미, U, V, W 매개변수 타입(별다른 의미X)
    
    *** 매개변수가 두 개인 함수형 인터페이스 ***
    함수형 인터페이스          메서드                   설명
    BiConsumer<T,U>         void accpet(T t, U u)   두개의 매개변수만 있고, 반환값 없응ㅁ
    BiPredicate<T,U>        boolean test(T t, U u)  조건식을 표현하는데 사용, 매개변수 둘, 반환값 boolean
    BiFunction<T,U,R>       R apply(T t, U u)       두 개의 매개변수를 받아서 하나의 결과를 반환

    UnaryOperator<T>        T apply(T t)            Function의 자손, Function과 달리 매개변수와 결과의 타입이 같음
    BinaryOperator<T>       T apply(T t, T t)       BiFunction의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같음
 */
class Ex14_2_utilFunctionPackage {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i%2==0;
        Function<Integer, Integer> f = i -> i / 10 * 10;        // i의 일의 자리 없앰

        List<Integer> list = new ArrayList<>();
        makeRandomeList(s, list);   // list 랜덤값으로 채움
        System.out.println(list);
        printEvenNum(p, c, list);   // 짝수 출력
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);


    }

    static <T> void makeRandomeList(Supplier<T> s, List<T> list) { // 람다식 s를 주면
        for(int i=0; i<10; i++) {
            list.add(s.get());  // Supplier로부터 1~100의 난수를 받아서 list에 추가
        }
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for(T i : list) {
            if(p.test(i)) { // 짝수인지 검사
                c.accept(i);    // 화면에 출력
            }
        }
        System.out.println("]");
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for(T i : list) {
            newList.add(f.apply(i));    // 일의 자리를 없애서 새로운 list에 저장
        }
        return newList;
    }
}
