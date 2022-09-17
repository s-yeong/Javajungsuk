package org.chapter14.ex;

/*
    스트림(stream) - 데이터의 연속적인 흐름
    다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
    데이터 소스를 추상화하였고, 데이터를 다루는데 자주 사용되는 메서드들을 정의해 놓음
    => 데이터 소스를 "모두 같은 방식으로 다룰 수 있다"

    데이터 소스를 추상화 
    -> 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되고
    -> 코드의 재사용성이 높아진다는 것을 의미

    데이터 소스
    컬렉션이나 배열같이 여러 데이터를 저장하고 있는 것들(List, Set, Map, 배열)

    데이터 소스 -> 1. 스트림 만들기 -> 2. 중간 연산(0~n번) -> 3. 최종 연산(0~1번)
    - 중간 연산은 여러번 할 수 있고 최종 연산은 딱 1번만 할 수 있다.
    - 중간 연산 : 연산결과가 "스트림"인 연산. 반복적으로 적용가능
    - 최종 연산 : 연산결과가 "스트림이 아닌" 연산. 단 한번만 적용가능 (스트림의 요소를 소모)
    => 마지막 최종 연산을 통해 우리가 원하는 결과를 얻을 수 있다

 */

/*
    스트림의 특징
    - 스트림은 데이터 소스를 변경하지 않는다.(데이터를 읽기만 할 뿐이다.)
    (필요하다면, 정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수도 있다.)

    - 스트림은 일회용이다. (Iterator처럼 한번 사용하면 닫혀서 다시 사용할 수 없다.)
    최종연산시 스트림이 닫힘 (필요하다면 스트림을 다시 생성해야함)

    - 스트림은 작업을 "내부 반복"으로 처리한다.
    "내부 반복"이라는 것은 반복문을 메서드의 내부에 숨겼다는 것을 의미한다.
    forEach()는 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.
    즉, forEach()는 메서드 안으로 for문을 넣은 것이다.

    - 지연된 연산
    최종 연산이 수행되기 전까지 "중간 연산이 수행되지 않는다"는 것이다.
    스트림에 대해 distinct()나 sort()같은 중간 연산을 호출해도 즉각적인 연산이 수행되지 않는다.
    중간 연산을 호출하는 것은 어떤 작업이 수행되어야하는지를 "체크만 해두는 것"일 뿐이다.
    최종 연산이 수행되어야 비로소 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모된다.

    - 기본형 스트림 - IntStream, LongStream, DoubleStream
    요소의 타입이 T인 스트림은 기본적으로 Stream<T>이지만, 오토박싱&언박싱으로 인한 비효율을 줄이기 위해,
    데이터 소스의 요소를 기본형으로 다루는 스트림, IntStream, LongStream, DoubleStream이 제공된다.
    => Stream<Integer> 대신 IntStream을 사용하는 것이 더 효율적이고,
    IntStream에는 int타입의 값으로 작업하는데 유용한 메서드들이 포함되어 있다.

    Stream<T>에서 T에는 기본형이 못온다..! 참조형만 가능
    {1,2,3} 에서 기본형인데 자동으로 1 -> new Integer(1)이 실행되어 참조형으로 바뀐다
    => 오토박싱!(9장)

    - 병렬 스트림
    스트림으로 데이터를 다룰 때의 장점 중 하나가 바로 "병렬 처리"가 쉽다는 것이다.
    병렬 스트림은 내부적으로 Java에서 제공하는 fork & join 프레임웤을 이용해서 자동적으로 연산을 병렬로 수행한다.
    => 스트림에 paralell()이라는 메서드를 호출해서 병렬로 연산을 수행한다
    => sequential() - 병렬로 처리되지 않게 하기    (병렬 취소)
    (모든 스트림은 기본적으로 병렬 스트림이 아니므로 sequential()을 호출할 필요가 없다)
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Ex14_5_Stream_1 {
    public static void main(String[] args) {

        String[] strArr = {"aaa", "ddd", "ccc"};    // 문자열 배열
        List<String> strList = Arrays.asList(strArr);   // 문자열 저장하는 List (배열을 list로 변환)

        // 이 두 데이터 소스를 기반으로 하는 스트림
        Stream<String> strStream1 = strList.stream();   // 스트림을 생성
        Stream<String> strStream2 = Arrays.stream(strArr);  // 스트림을 생성

        // 이 두 스트림으로 데이터 소스의 데이터를 읽어서 정렬하고 화면에 출력하는 방법
        strStream1.sorted().forEach(System.out::println);   // 데이터 소스가 정렬되는 것이 아님!
        strStream2.sorted().forEach(System.out::println);   // 데이터 소스가 정렬되는 것이 아님!
        // ---> 두 스트림의 데이터 소스는 서로 다르지만, 정렬하고 출력하는 방법은 완전 동일하다!
        // 중간연산 - sorted(), 최종연산 - forEach()

        // 정렬된 결과를 새로운 List에 담아서 반환한다. (이 때 오류가 나는 이유는 스트림은 일회용이니까 새로 생성해야함!)
//        List<String> sortedList = strStream2.sorted().collect(Collectors.toList());

    }
}
