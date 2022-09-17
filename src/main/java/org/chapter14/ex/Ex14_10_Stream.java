package org.chapter14.ex;


/*
    스트림의 그룹화와 분할
    그룹화 : 스트림의 요소를 특정 기준으로 그룹화하는 것
    분할 : 스트림의 요소를 두가지, 지정된 조건에 일치하는 그룹과 일치하지 않는 그룹으로의 분할

    ** Collectors에 있는 메소드 **
    groupingBy() - 스트림을 n분할! (스트림의 요소를 Function으로)
    partitioningBy() - 스트림을 2분할! (Predicate로 분류)

    Collector groupingBy(Function classifier)
    Collector groupingBy(Function classifier, Collector downstream)
    Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)

    Collector partitioningBy(Predicate predicate)
    Collector partitioningBy(Predicate predicate, Collector downstream)

    => 스트림을 두 개의 그룹으로 나눠야 한다면 partitioningBy()로 분할하는 것이 더 빠르다
    그 외에는 groupingBy()를 쓰면 된다!  (그룹화와 분할의 결과는 Map에 담겨 반환)
 */

/*
    스트림의 분할 - partitioningBy()
 */

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }

    enum Level {
        HIGH, MID, LOW  // 성적을 상, 중 ,하 세 단계로 분류
    }
}
public class Ex14_10_Stream {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true,  1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true,  1, 1, 200),
                new Student2("이지미", false, 1, 2, 150),
                new Student2("남자바", true,  1, 2, 100),
                new Student2("안지미", false, 1, 2,  50),
                new Student2("황지미", false, 1, 3, 100),
                new Student2("강지미", false, 1, 3, 150),
                new Student2("이자바", true,  1, 3, 200),
                new Student2("나자바", true,  2, 1, 300),
                new Student2("김지미", false, 2, 1, 250),
                new Student2("김자바", true,  2, 1, 200),
                new Student2("이지미", false, 2, 2, 150),
                new Student2("남자바", true,  2, 2, 100),
                new Student2("안지미", false, 2, 2,  50),
                new Student2("황지미", false, 2, 3, 100),
                new Student2("강지미", false, 2, 3, 150),
                new Student2("이자바", true,  2, 3, 200)
        };

        System.out.printf("1. 단순분할(성별로 분할) %n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);
        for(Student2 s : maleStudent) System.out.println(s);
        for(Student2 s : femaleStudent) System.out.println(s);
//        for(int i = 0 ; i < femaleStudent.size(); i++) System.out.println(femaleStudent.get(i));

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy((Student2::isMale), counting()));   // counting을 통해 요소가 몇 개 인지 셈
        System.out.println("stuNumBySex.get(true) = " + stuNumBySex.get(true));
        System.out.println("stuNumBySex.get(false) = " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        maxBy(comparingInt(Student2::getScore))
                ));
        System.out.println("topScoreBySex.get(true) = " + topScoreBySex.get(true));
        System.out.println("topScoreBySex.get(false) = " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student2::getScore)), Optional::get  // Optional 값을 꺼내서 반환
                        )
                ));
        System.out.println("topScoreBySex2.get(true) = " + topScoreBySex2.get(true));
        System.out.println("topScoreBySex2.get(false) = " + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별, 불합격자 100점 이하)%n"); // 남 - 합/불  여 - 합/불

        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = Stream.of(stuArr).
                collect(partitioningBy(Student2::isMale,    // 성별로 분할
                partitioningBy(s -> s.getScore() <= 100))   // 성적으로 분할
        );

        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(Student2 s : failedMaleStu) System.out.println(s);
        for(Student2 s : failedFemaleStu) System.out.println(s);

    }
}
