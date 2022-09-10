package org.chapter6.exercise;

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    int getTotal() {
        // 국어 영어, 수학 점수 모두 더해서 반환
        return kor + eng + math;
    }

    float getAverage() {
        // 평균 구하기, 소수점 둘째자리에서 반올림
        return (int)((getTotal()/3f)*10f + 0.5f) / 10f;
        // 3f로 나누고, 첫째 자리에서 반올림하기 위해서 10 곱한다음 0.5f 더하기
        // 첫째 자리까지 나타내기 위해 10f 다시 나누기
    }
}

public class Exercise6_3 {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 1, 1, 100, 60, 76);

        System.out.println(s.getTotal());
        System.out.println(s.getAverage());
    }
}
