package org.chapter14.ex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *     collect() - 스트림의 최종연산, 매개변수로 컬렉터를 필요로함
 *     Collector - 인터페이스, 컬렉터는 이 인터페이스를 구현해야함
 *     Collectors - 클래스, static 메서드로 미리 작성된 컬렉터를 제공
 */
// reduce() : 리듀싱 (전체)  - 스트림 요소 전체에 대해서
// collect() : 그룹별 리듀싱 (그룹별 나눠서)

/*
    최종 연산 중 가장 복잡하면서도 유용하게 활용될 수 있는 것
    collect()   - 그룹별 나눠서 리듀싱이 가능
    스트림의 요소를 수집하는 최종 연산 (리듀싱(reducing)과 유사)

    Object collect(Collector collector)
    (잘 안씀) Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
    - Collector 인터페이스를 구현하지 않고, 간단한 람다식으로 수집할떄 사용하면 편리

    Collector
    수집에 필요한 메서드를 정의해 놓은 "인터페이스"
    (직접 구현할 수도 있고, 미리 작성된 것을 사용할 수도 있음)
    // Collector<T,A,R> 스트림 요소 T를 A에 누적한 다음 결과를 R로 변환해서 반환
    핵심** supplier() - 누적할 곳
    핵심** accumulator() - 누적 방법
    combiner() - 결합방법 (병렬작업 했을 때 각각 쓰레드가 작업한 것을 합치는 것)
    finisher() - 최종변환
    characteristics() - 컬렉션 특성이 담긴 Set을 반환

    Collectors "클래스"는 미리 작성된 다양한 종류의 컬렉터를 반환하는
    static 메서드를 가지고 있음 ( 이 클래스를 통해 제공되는 컬렉터만으로도 많은 일 가능)
    - 변환, 통계, 문자열 결합, 리듀싱, 그룹화와 분할

    sort()할 때, Comparator가 필요한 것처럼 collect()할 때는 Collector가 필요
 */

/*
    스트림을 컬렉션으로 변환
    toList(), toSet(), toMap(), toCollection()      - Collectors에 static 메서드로 구현되어 있음

    스트림의 모든 요소를 컬렉션에 수집하려면,
    Collectors 클래스의 toList()와 같은 메서드를 사용하면 된다.
    List나 Set이 아닌 특정 컬렉션을 지정하려면,
    toCollection()에 원하는 컬렉션의 생성자 참조를 매개변수로 넣어주면 된다.

    List<String> names = stuStream.map(Student::getName)    // Stream<Student> -> Stream<String>
                            .collect(Collectors.toList());  // Stream<String> -> List<String>
    => 학생들 이름만 뽑아서, List에 담음

    => 특정 컬렉션 지정 ex) ArrayList
    ArrayList<String> list = names.stream()
        .collect(Collectors.toCollection(ArrayList::new))   // Stream<String> -> ArrayList<String>
    (원하는 컬렉션의 생성자 참조를 매개변수로 넣자)

    => Map에 담을 수도 있음
    Map<String, Person> map = personStream
                    .collect(Collectors.toMap(p->p.getRegId(), p -> p)  // Stream<Person> -> Map<String, Pereson>
    => Map은 key, value가 있기 때문에 둘 다 정해줘야함 toMap(key, value)
    
    스트림을 배열로 변환 - toArray()
    Student[] stuNames = studentStream.toArray(Student[]::new); // OK
    Student[] stuNames = studentStream.toArray();   // 에러
    Object[] stuNames = studentStream.toArray();    // 매개변수 없는 것은 Object로 반환!!!

    스트림의 통계 - counting(), summingInt()
    스트림의 통계 정보 제공 - counting(), summingInt(), maxBy(), minBy() ...
    "collect()"로도 카운팅, 썸 가능하다!
    long count = strStream.count(); // 전체 카운팅만
    long count = strStream.collect(Collectors.counting());  // 그룹별로 나눠서 세는게 가능

    long totalScore = stuStream.mapToInt(Student::getTotalScore).sum(); // IntStream의 sum()
    long totalScore = stuStream.collect(Collectors.summingInt(Student::getTotalScore))

    OptionalInt topScore = studentStream.mapToInt(Student::getTotalScore).max()
    Optional<Student> topStudent = stuStream.collect(maxBy(Comparator.comparingInt(Student::getTotalScore)));
 */
/*
    스트림을 리듀싱 - reducing()   - sum(), count() ...
    "Collectors"가 가지고 있음(그룹별 리듀싱 가능), 하는일 reduce()와 같음 (reduce()는 전체 리듀싱)

    ** Collector reducing(T identity, BinaryOperator<T> op)     - 대부분 이거 쓰면 됨
    Collector reducing(BinaryOperator<T> op)       - BinaryOperator가 reduce()의 accumulator라고 생각하면 될듯
    Collector reducing(U identity, Function<T,U> mapper, BinaryOperator<U> op)  - 변환이 필요하면 (T-> U)

    OptionalInt max = intStream.reduce(Integer::max);   // 전체 리듀싱
    Optional<Integer> max = intStream.boxed().collect(reducing(Integer::max)); // 그룹별 리듀싱 가능

    int grandTotal = stuStream.map(Student::getTotalScore).reduce(0, Integer::sum);
    int grandTotal = stuStream.collect(reducing(0, Student::getTotalScore, Integer::sum));

    스트림을 문자열로 결합 - joining()
    "Collectors"가 가지고 있는 메서드
    문자열 스트림의 모든 요소를 하나의 문자열로 연결해서 반환
    (구분자 지정 가능, 접두사 접미사 지정 가능)
    - 스트림의 요소가 문자열이 아닌 경우 map()을 이용해 문자열로 변환하자

    => 하나의 문자열로!            Stream<Student> -> Stream<String>
    String studentNames = stuStream.map(Student::getName).collect(Collectors.joining());
    String studentNames = stuStream.map(Student::getName).collect(Collectors.joining(","));    // 구분자
    String studentNames = stuStream.map(Student::getName).collect(Collectors.joining(",", "[", "]"));
*/
class Ex14_9_Stream_2 {
    public static void main(String[] args) {

    }
}
