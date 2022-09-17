package org.chapter14.ex;
// 1. 스트림 만들기 2. 중간연산 3. 최종연산

/*
    스트림 만들기 - 컬렉션
    Collection의 자손 - List, Set을 구현한 컬렉션 클래스들은 이 방식으로 스트림 생성

    Stream<E> stream()  // Collection 인터페이스의 메서드
    => 해당 컬렉션을 소스로 하는 스트림을 반환

    스트림 만들기 - 배열
    Stream과 Arrays에 static 메서드로 정의되어 있음
    Stream<T> Stream.of(T... values) // 가변 인자
    Stream<T> Stream.of(T [])
    Stream<T> Arrays.stream(T[])
    Stream<T> Arrays.stream(T[] arrays, inst startInclusive, int endExclusive)
    - 기본형 스트림의 경우 IntStream 등으로도 가능

    스트링 만들기 - 임의의 수
    Random 클래스의 인스턴스 메서드들 (해당 타입의 난수들로 이루어진 스트림 반환)
    IntStream ints()
    LongStream longs()
    DoubleStream doubles()
    => 크기가 정해지지 않은 "무한 스트림" 이다!!
    => limit()도 같이 사용해서 스트림의 크기를 제한해 주어 유한 스트림으로 만들어 줘야 한다!

    - 유한 스트림 임의의 수 만들기
    IntStream ints(long streamSize) ...

    스트림 만들기 - 특정 범위의 정수
    IntStream과 LongStream은 지정된 범위의 연속된 정수를 스트림으로 생성해서 반환하는
    range()와 rangeClosed()가 있음
    IntStream IntStream.range(int begin, int end) // end가 범위에 포함X
    IntStream IntStream.rangeClosed(int begin, int end) // end가 범위에 포함O
    (만약 큰 범위의 스트림 생성? -> LongStream)
    
    스트림 만들기 - 람다식 iterate(), generate()
    iterate()와 generate()는 람다식을 매개변수로 받아서,
    이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림 생성
    - static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
    => 씨앗값(seed)으로 지정된 값부터 시작해서, 람다식 f에 의해 계산된 결과를 다시 seed 값으로 해서 계산을 반복
    - static <T> Stream<T> generate(Supplier<T> s)
    <-> 무한 스트림을 생성해서 반환하지만, 이전 결과를 이용해서 다음 요소를 계산하지는 않음
    => 매개변수가 없는 람다식만 허용!

    (두 메소드 다 기본형 스트림 타입의 참조변수로 다룰 수없음)
    
    스트림 만들기 - 파일
    java.nio.file.Files는 파일을 다루는데 필요한 유용한 메서드들을 제공
    Stream<Path> Files.list(Path dir)   // Path는 하나의 파일 또는 경로
    => list()는 지정된 디렉토리(dir)에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환

    => 파일의 한 행(line)을 요소로 하는 스트림을 생성하는 메서드
    Stream<String> Files.lines(Path path)
    Stream<String> Files.lines(Path path, Charset cs)
    Stream<String> lines() // BufferReader 클래스에 속한 메서드 (파일 뿐만 아니라 다른 입력대상으로부터도 데이터를 행단위로 읽어올 수 있음)

    // 스트림 만들기 - 빈 스트림
    요소가 하나도 없는 비어있는 스트림 생성
    (스트림에 연산을 수행한 결과가 하나도 없을 때, null보다 빈 스트림을 반환하는 것이 낫다)
    Stream emptyStream = Stream.empty(); // empty()는 빈 스트림을 생성해서 반환함
    long count = emptyStream.count();   // count의 값은 0
    count()는 스트림 요소의 개수를 반환
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Ex14_5_Stream_2 {
    public static void main(String[] args) {

        // 스트림 만들기 - 컬렉션
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);// 가변인자
        Stream<Integer> intStream = list.stream();

        // 스트림 만들기 - 배열
        // 문자열
        Stream<String> strStream = Stream.of("a", "b", "c");    // 가변인자
        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c"});
        Stream<String> strStream3 = Arrays.stream(new String[]{"a", "b", "c"});
        Stream<String> strStream4 = Arrays.stream(new String[]{"a", "b", "c"}, 0, 3);
        // 정수
        int[] intArr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(intArr);
        // Stream<Integer> steram = Arrays.stream(intArr);로 변경시 에러
        // -> "기본형 배열"이면 안된다!
        Integer[] intArr2 = {1,2,3,4,5}; // {new Integer(1), new Integer(2) ...}
        Stream<Integer> steram2 = Arrays.stream(intArr2);   // Integer 객체 스트림
//        System.out.println("count=" + stream.count()); // 최종 연산
//        System.out.println("sum=" + stream.sum());    // 최종 연산
        System.out.println("average=" + stream.average()); // 최종 연산

        // 스트림 만들기 - 임의의 수
        IntStream intStream2 = new Random().ints(); // 무한 스트림
        intStream2.limit(5);    // -> 유한 스트림
        IntStream intStream3 = new Random().ints(5); // 유한 스트림
        IntStream intStream6 = new Random().ints(1, 100); // 지정된 범위의 난수
        IntStream intStream7 = new Random().ints(5, 1, 100);

        // 스트림 만들기 - 특정 범위의 정수
        IntStream intStream4 = IntStream.range(1, 5);   // 1~4
        IntStream intStream5 = IntStream.rangeClosed(1, 5); // 1~5

        // 스트림 만들기 - 람다식 iterate(), generate()
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        // -> 0부터 시작해서 값이 2씩 계속 증가 (무한 스트림 생성)
        Stream<Double> randomStream = Stream.generate(Math::random);
        Stream<Integer> oneStream = Stream.generate(() -> 1);

    }
}
