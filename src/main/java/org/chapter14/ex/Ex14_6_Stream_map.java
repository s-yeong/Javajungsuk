package org.chapter14.ex;

import java.io.File;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/*
    스트림의 중간연산 - map()
    스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 때

    Stream<R> map(Function<? super T,? extends R> mapper)
    매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야함
    Stream<T> -> Stream<R>
 */
/*
    스트림의 중간연산 - peak()
    연산과 연산 사이에 올바르게 처리되었는지 확인하고 싶다면, peek() 사용!
    <-> forEach()와 달리 스트림의 요소를 소모하지 않으므로 연산 사이에 여러 번 끼워 넣어도 문제X
    filter()나 map()의 결과를 확인할 때 유용하게 사용할 수 있다!
 */
public class Ex14_6_Stream_map {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
        };

        Stream<File> fileStream = Arrays.stream(fileArr);

        // 파일의 이름만 뽑아서 출력하고 싶을 때,
        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);    // 모든 파일의 이름 출력

        // 최종 연산 했으므로 스트림 다시 생성
        fileStream = Stream.of(fileArr);

        fileStream.map(File::getName)   // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것 제외
//                .peek(s-> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출 Stream<String> -> Stream<String>
//                .peek(s-> System.out.printf("extension=%s%n", s))
                .map(String::toUpperCase) // 대문자로 변환    // Stream<String> -> Stream<String>
//                .peek(s-> System.out.printf("after UpperCase=%s%n", s))
                .distinct() // 중복 제거
                .forEach(System.out::println);
        System.out.println();
    }
}

