package org.chapter14.ex;
/*
    스트림의 그룹화 - gropingBy()
    groupingBy() - 스트림의 요소를 Function으로

    Collector groupingBy(Function classifier)
    Collector groupingBy(Function classifier, Collector downstream)
    Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
 */

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

class Student3 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student3(String name, boolean isMale, int hak, int ban, int score) {
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

class Ex14_11_Stream {
    public static void main(String[] args) {

        Student3[] stuArr = {
                new Student3("나자바", true,  1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true,  1, 1, 200),
                new Student3("이지미", false, 1, 2, 150),
                new Student3("남자바", true,  1, 2, 100),
                new Student3("안지미", false, 1, 2,  50),
                new Student3("황지미", false, 1, 3, 100),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true,  1, 3, 200),
                new Student3("나자바", true,  2, 1, 300),
                new Student3("김지미", false, 2, 1, 250),
                new Student3("김자바", true,  2, 1, 200),
                new Student3("이지미", false, 2, 2, 150),
                new Student3("남자바", true,  2, 2, 100),
                new Student3("안지미", false, 2, 2,  50),
                new Student3("황지미", false, 2, 3, 100),
                new Student3("강지미", false, 2, 3, 150),
                new Student3("이자바", true,  2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student3::getBan, toList())); // toList() 생략가능 (default)
        // groupingBy()로 그룹화 하면 기본적으로 List<T>에 담음
        // 만일 원한다면, toList()대신 tosSet()이나 toCollection(HashSet::new) 사용 가능

//        Collection<List<Student3>> values = stuByBan.values();
        for(List<Student3> ban : stuByBan.values()) {
            for(Student3 s : ban) System.out.println(s);
        }

        System.out.printf("%n2. 단순그룹화(성젹별로 그룹화)%n");
        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                            if (s.getScore() >= 200) return Student3.Level.HIGH;
                            else if (s.getScore() >= 100) return Student3.Level.MID;
                            else return Student3.Level.LOW;
                        }
                ));

        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(Student3.Level key : keySet) {
            System.out.println("[" + key + "]");

            for(Student3 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                            if (s.getScore() >= 200) return Student3.Level.HIGH;
                            else if (s.getScore() >= 100) return Student3.Level.MID;
                            else return Student3.Level.LOW;
                        }, counting()
                ));

        for(Student3.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();

        // 학년<반,>
        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student3::getHak,
                        groupingBy(Student3::getBan)
                ));

        for (Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
            for(List<Student3> ban : hak.values()) {
                System.out.println();
                for(Student3 s : ban) System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student3>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student3::getHak,
                        groupingBy(Student3::getBan,
                                collectingAndThen(
                                        maxBy(comparingInt(Student3::getScore))
                                        , Optional::get
                                )
                        )
                ));

        for(Map<Integer, Student3> ban : topStuByHakAndBan.values())
            for(Student3 s : ban.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");

        Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(), // 학년하고 반을 뽑아서 문자를 만들어서 분류
                        // 학년과 반을 통째로 그루핑함
                        mapping(s -> {  // map()과 같음 (변환함수) - 특별한 기준을 만들어서 분류할 때!
                            if (s.getScore() >= 200) return Student3.Level.HIGH;
                            else if (s.getScore() >= 100) return Student3.Level.MID;
                            else return Student3.Level.LOW;
                        }, toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }


    }
}
