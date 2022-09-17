package org.chapter14.ex;

/*
    스트림의 최종연산 - forEach()
    최종 연산은 스트림의 요소를 소모해서 결과를 만들어냄 -> 스트림이 닫힘
    최종 연산의 결과는 스트림 요소의 합과 같은 단일 값이거나, 스트림의 요소가 담긴 배열 또는 컬렉션일 수 있음
    - forEach()
    - forEachOrdered() - 병렬스트림인 경우 순서 보장을 위해 (forEach()는 순서 보장X)  병렬 처리 - 여러 쓰레드가 나눠서 처리
    
    스트림의 최종연산 - 조건검사 ( 매개변수 Predicae 요구, boolean 반환 )
    - allMatch()    모든 요소가 일치하면 참
    - anyMatch()    하나의 요소라도 일치하면 참
    - noneMatch()   모든 요소가 불일치하면 참

    반환 타입 Optional<T>, 스트림의 요소가 없을 때는 비어있는 Optional 객체 반환
    - findFirst()   조건에 일치하는 첫 번째 것을 반환 (주로 filter()와 함께 사용)
    - findAny()     조건에 일치하는 요소를 하나 반환 (병렬 스트림)
    (조건에 일치하는게 없어서 null일 수 있기에 Optional로 감싸줌)

    스트림의 최종연산 - reduce()
    스트림의 요소를 줄여나가면서 연산을 수행하고, 최종 결과 반환
    매개변수 타입 BinaryOperator<T> - 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소 연산
    (스트림의 모든 요소를 소모하게 되면 그 결과 반환)
    Optional<T> reduce(BinaryOperator<T> accumulator)

    "연산결과의 초기값"(identity)을 갖는 reduce()도 있다.
    이 메서드들은 초기값(과 스트림의 첫 번쨰 요소로 연산을 시작한다. 스트림의 요소가 하나도 없는 경우,
    초기값이 반환되므로, 반환 타입이 Optional<T>가 아니라 T이다.
    T reduce(T identity, BinaryOperator<T> accumulator)
    U reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
    (매개변수 combiner는 병렬 스트림에 의해 처리된 결과를 합칠 때 사용하기 위한 것)

    identity - 초기값, accumulator - 이전 연산결과와 스트림의 요소에 수행할 연산
 */

/*
    reduce() 이해
        int a = identity; // 초기값 a 저장
        for(int b : stream)
            a = a + b;  // 모든 요소의 값을 a에 누적

    => 다음과 같이 reduce()가 작성되어 있을 것이라고 추측할 수 있음
        T reduce(T identity, BinaryOperator<T> accumulator) {
            T a = identity;

            for(T b : stream)
                a = accumulator.apply(a, b);
            return a;
        }
    => 초기값(identity)과 어떤 연산(BinaryOperator)으로 스트림의 요소를 줄여갈 것인지만 결정하면 된다!!
 */

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Ex14_9_Stream_1 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1,9).sequential().forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1,9).sequential().forEachOrdered(System.out::print);
        System.out.println();
        // sequential() 생략 가능 ( 디폴트임 )
        IntStream.range(1, 10).parallel().forEach(System.out::print); // 병렬스트림인 경우 순서 보장X
        System.out.println();
        IntStream.range(1, 10).parallel().forEachOrdered(System.out::print);
        System.out.println();



        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Arrays.stream(strArr).forEach(System.out::println);

        // noneMatch()   모든 요소가 불일치하면 참
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);

        // findFirst()   조건에 일치하는 첫 번째 것을 반환 (주로 filter()와 함께 사용)
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.get());   // Optional로 감싸져있는거 품

        // Stream<String>을 IntStream으로 변환 - 각 요소를 기본형으로 다룸
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        // Streram<String>을 Stream<Integer>로 변환 - 각 요소를 객체로 다룸
        Stream<Integer> integerStream = Stream.of(strArr).map(String::length);

        // 스트림의 요소를 줄여나가면서 연산을 수행하고, 최종 결과 반환
        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);  // 초기값이 없기 떄문에 비어져 있을 수 있으니 Optional
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max.getAsInt());  // Optional로 감싸져있는거 품
        System.out.println("min = " + min.getAsInt());  // Optional로 감싸져있는거 품

    }
}
