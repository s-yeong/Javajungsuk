package org.chapter14.ex;
/**
 * 메서드 참조 -> 람다식으로 바꿀 때
 * 1. () -> 메서드
 * 2. 참조변수 생각
 */

// 정렬 -> 1. 정렬 대상, 2. 정렬 기준
/*
    스트림의 중간연산 - sorted()
    지정된 Comparator로 스트림 정렬하는데, int값 반환하는 람다식을 사용하는 것도 가능!!

    스트림의 중간연산 - Comparator의 메서드
    -> 이 메서드들을 이용하면 정렬이 쉬워짐

    모두 Comparatr<T>를 반환
    comparing(Function<T, U> keyExtractor)
    comparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)
    -> 스트림의 요소가 Comparable을 구현한 경우, 매개변수 하나짜리를 사용하면 되고,
    그렇지 않으면 추가적인 매개변수로 정렬기준(Comparator)을 따로 지정해 줘야한다.

    comparingInt(ToIntFunction<T> keyExtractor)
    comparingLong(ToLongFunction<T> keyExtractor)
    comparingDouble(ToDoubleFunction<T> keyExtractor)
    -> 비교대상이 기본형인 경우, comparing()대신 위의 메서드를 사용하면
    오토박싱과 언박싱 과정이 없어서 더 효율적

    정렬 조건 추가
    thenComparing(Comparator<T> other)
    thenComparing(Function<T, U> keyExtractor)
    thenComparing(Function<T, U> keyExtractor, Comparator<U> keyComp)


 */


import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5_Stream_4 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(  // 배열을 스트림으로 변환
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan).reversed()  // 반별 정렬
                // 람다식  (Student s) -> s.getBan()
                        .thenComparing(Comparator.naturalOrder()))  // 기본 정렬 (Comparable)
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student>{

    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;  // 총점 내림차순 정렬을 기본 정렬로 한다

    }
}