package org.chapter11.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Student 클래스가 Comparable 인터페이스를 구현하도록 변경해서
// nmae이 기본 정렬기준이 되도록 하기
class Student implements Comparable{
    String name;
    int ban;
    int no;
    int kor, eng, math;

    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor+eng+math;
    }

    float getAverage() {
        return (int)((getTotal()/3f)*10+0.5)/10f;
    }

    public String toString() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + ","
                + math + "," + getTotal() + "," + getAverage();
    }

    @Override
    public int compareTo(Object o) {
        // 양수, 0, 음수 표현해줘야함 compareTo는 인스턴스 자신과 비교해서
        // 자신이 작으면 음수, 같으면 0, 크면 양수를 반환하도록 구현
        // Student 객체로 변환하기
        if(o instanceof Student) {
            Student s = (Student) o;
            // 오름차순 - String 서로 비교하려면 어찌함?
            // => String 클래스의 compareTo 호출!!!!!!!!
            return name.compareTo(s.name);
        }
        return -1;
    }
}
class Exercise11_3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student("김자바", 1, 3, 90, 70, 80));
        list.add(new Student("이자바", 1, 4, 70, 90, 70));
        list.add(new Student("안자바", 1, 5, 60, 100, 80));


        // sort 메서드 사용하려면
        // ArrayList에 저장된 요소들은 모두 Comparable 인터페이스를 구현한 것이어야함!
        // 정렬기준이 있어야함 -> Student의 정렬기준이 있어야함
        Collections.sort(list);
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
