package org.chapter11.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// ArraayList에 담긴 Student 인스턴스를 ban과 no로 오름차순 정렬되게 하기
// ban이 같은 경우 no 비교해서 정렬
class BanNoAscending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if(!(o1 instanceof Student && o2 instanceof Student)) {
            return -1;
        }

        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        // 정렬기준을 차이로 구하는 방법이 있다!!!!!
        int result = s1.ban - s2.ban;

        if(result == 0) {
            return s1.no - s2.no;
        }
        return result;
        // 삼항연산자를 통해 작성
        // return s1.ban == s2.ban ? s1.no - s2.no : s1.ban - s2.ban;

    }
}

class Exercise11_4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(new Student("이자바", 2, 1, 70, 90, 70));
        list.add(new Student("안자바", 2, 2, 60, 100, 80));
        list.add(new Student("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student("김자바", 1, 2, 90, 70, 80));

        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
