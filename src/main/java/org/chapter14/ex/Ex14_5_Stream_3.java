package org.chapter14.ex;

/*
    스트림의 연산
    스트림이 제공하는 다양한 연산을 이용하면 복잡한 작업들을 간단히 처리할 수 있음
    (데이터베이스에서 select문으로 쿼리하는 것과 같은 느낌)
    (데이터 소스를 다루는 작업을 수행하는 것을 연산이라고 함)

    중간 연산
    - 연산결과를 스트림으로 반환, 연속해서 연결할 수 있음
    - 모든 중간 연산의 결과는 스트림이지만, 연산 전의 스트림과 같은 것은 아니다.

    최종 연산
    - 스트림 요소를 소모하므로 단 한번만 연산이 가능
 */

/*
    중간 연산
    dintinct() - 중복 제거
    filter(Predicate<T> predicate) - 조건에 안 맞는 요소 제외
    limit(long maxSize) - 스트림의 일부 잘라냄
    skip(long n) - 스트림의 일부를 앞에서부터 건너뜀
    peek(Consumer<T> action) - 스트림의 요소에 작업수행
    sorted(),sorted(Comparator<T> comparator) - 스트림의 요소를 정렬

    핵심 *** map(), flatMap() - 스트림의 요소를 변환
 */

/*
    최종 연산
    void forEach(Comsuer<? super T> action) - 각 요소에 지정된 작업 수행
    void forEachOrdered(Consumer<? super T> action) - 각 요소에 지정된 작업 수행(순서 유지 기능 - 병렬 스트림으로 처리 시)
    long count() - 스트림의 요소의 개수 반환
    Optional<T> max(Comparator<? super T> comparator) - 스트림의 최대값/최소값(min) 반환
    Optional<T> findAny() - 스트림의 요소 아무거나 하나 반환  - filter와 같이 쓰임
    Optional<T> findFirest() - 스트림의 첫번째 요소 반환  - filter와 같이 쓰임
    boolean allMatch(Predicate<T> p) - 조건을 모두 만족하는지 확인
    boolean anyMatch(Predicate<T> p) - 조건을 하나라도 만족하는지 확인
    boolean noneMatch(Predicate<T> p) - 조건을 모두 만족하지 않는지 확인
    Object[] toArray() - 스트림의 모든 요소를 배열로 변환
    A[] toArray(IntFunction<A[]> generator) - 스트림의 모든 요소를 배열로 변환

    핵심 ***
    Optional<T> reduce(BinaryOperator<T> accumulator)
    T reduce(T identity, BinaryOperator<T> accumulator)
    U reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<U> combiner)
    => 스트림의 요소를 하나씩 줄여가면서(리듀싱) 계산
    ex) sum인 경우 1,2,3,4,5가 있을 때 하나씩 줄여가면서 더함

    핵심 ***
    R collect(Collector<T,A,R> collector)
    R collect(Supplier<R> supplier, BiConsumer<R,T> accumulator, BiConsumer<R,R> combiner)
    => 스트림의 요소를 수집
    주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 반환하는데 사용

 */

import java.util.stream.IntStream;

class Ex14_5_Stream_3 {

    public static void main(String[] args) {

        // 스트림의 중간연산 - skip(3), limit(5) -> 처음 3개의 요소를 건너뛰고, 스트림의 요소를 5개로 제한
        IntStream intStream = IntStream.rangeClosed(1, 10);// 1~10의 요소를 가진 스트림
        intStream.skip(3).limit(5).forEach(System.out::print);
        System.out.println();

        // 스트림의 중간연산 - distinct() -> 중복 제거
        IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
        intStream2.distinct().forEach(System.out::print);
        System.out.println();
        
        // 스트림의 중간연산 - filter(람다식) -> 조건에 맞지 않는 요소 걸러냄
        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i%2 == 0).forEach(System.out::print);
        System.out.println();
    }
}
