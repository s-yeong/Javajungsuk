package org.chapter11.ex;

// List -> ArrayList
// 순서 O, 중복 O, 모든 종류의 객체(Object)를 담을 수 있다.
// 인덱스 0부터 시작
import java.util.*;

/*
    ArrayList 추가와 삭제
    ArrayList 요소를 삭제하는 경우, 
    삭제할 객체의 바로 아래에 있는 데이터를 한 칸씩 위로 복사해서 삭제할 객체를 덮어쓰는 방식으로 처리
    만약 삭제할 객체가 마지막 데이터면, 복사할 필요 없이 null로 변경해준다 (모든 데이터 삭제는 마지막 데이터 부터 null로 계속 처리하기)

    1. 삭제할 데이터의 아래에 있는 데이터를 한 칸씩 위로 복사해서 삭제할 데이터를 덮어쓴다.
    2. 데이터가 모두 한 칸씩 위로 이동하였으므로 마지막 데이터는 null로 변경해야한다.
    3. 데이터가 삭제되어 데이터의 개수가(size)가 줄었으므로 size의 값을 1 감소시킨다.
 */


class Ex11_1_ArrayList {
    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println();
    }
    public static void main(String[] args) {

        // 지정된 초기용량(10)을 갖는 ArrayList 생성
        ArrayList list1 = new ArrayList(10);
        // ArrayList의 마지막에 객체를 추가. 성공하면 true
        list1.add(5);   // list1.add(new Integer(5)) => 컴파일러가 autoboxing을 해줌
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);

        // list1.subList(1,4) => 1부터 4전까지 저장된 객체 반환
        // ArrayList(Collection C) => 주어진 컬렉션이 저장된 ArrayList를 생성
        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1,list2);

        // Collections.srot(Lists l) => list1과 list2 정렬
        // Collection은 인터페이스, Collections는 유틸 클래스
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1,list2);

        // list1.containsAll => list1이 list2의 모든 요소를 포함하고 있는 경우
        System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        // 인덱스가 3인 곳에 "A"를 추가
        list2.add(3, "A");
        print(list1,list2);

        // list1.indexOf() => 지정된 저장된 위치 반환, 없으면 -1
        System.out.println("index = " + list1.indexOf("C"));
        System.out.println("index = " + list2.indexOf("C"));

        // 인덱스가 3인 곳을 "AA"로 변경
        list2.set(3, "AA");
        print(list1,list2);

        // list1에서 list2와 겹치는 부분만 남기고 나머지 삭제
        System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
        print(list1,list2);

        
        // list2에서 list1에 포함된 객체들을 삭제
        for(int i=list2.size()-1; i>=0; i--) {
            // list2의 객체가 list1에 포함되어 있는지 확인
            // list2.get(i) => i index에 저장된 객체 반환
            if(list1.contains(list2.get(i)))
                // 지정된 위치 i index에 있는 객체 제거
                list2.remove(i);
        }
        print(list1,list2);
        
    }


}
