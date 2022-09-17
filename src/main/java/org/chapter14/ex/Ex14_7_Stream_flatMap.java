package org.chapter14.ex;

/*
    스트림의 중간연산 - flatMap()
    마찬가지로 변환, 차원을 줄여줌( 스트림의 스트림 -> 스트림 )
    스트림의 타입이 Stream<T[]>인 경우, Stream<T>로 변환해야 작업이 더 편리하다!

    map() flatMap() 차이
    Stream<String[]> -----> Stream<Stream<String>>
    Stream<String[]> -----> Stream<String>

    Stream<String> -----> Stream<Stream<String>>    map(s->System.of(s.split(" ")))
    Stream<String> -----> Stream<String>    flatMap(s->System.of(s.split(" ")))

 */

import java.util.Arrays;
import java.util.stream.Stream;

class Ex14_7_Stream_flatMap {
    public static void main(String[] args) {

        // 각 요소의 문자열들을 합쳐서
        // 문자열이 요소인 스트림인, Stream<String>으로 변환해야한다!
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

//        Stream<Stream<String>> streamStream = strArrStrm.map(Arrays::stream);
        // 스트림의 요소를 변환해야하기 때문에 map()을 사용했는데
        // Stream<Stream<String>> 형태가 되었다!! => 스트림의 스트림!
        // 각 요소의 문자열들이 합쳐지지 않고, 스트림의 스트림 형태로 되어버렸다


        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
        // flatMap()을 사용하면 된다!

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // " +"는 정규식 표현으로 하나 이상의 공백을 의미,
                // s.split(" +")의 결과는 문자열 s를 공백을 구분자로 자른 문자열 배열
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();


    }
}
