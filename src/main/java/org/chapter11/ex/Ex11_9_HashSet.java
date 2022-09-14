package org.chapter11.ex;

/*
    Hashset
    Set 인터페이스를 구현한 가장 대표적인 컬렉션
    - 중복된 요소 저장X
    - 새로운 요소를 추가할 때는 add메서드나 addAll메서들르 사용
    - HashSet에 중복된 요소를 추가하고자 한다면 false를 반환함
        -> 컬렉션 내의 중복 요소들을 쉽게 제거할 수 있음
    - 저장순서 유지하려면 LinkedHashSet 사용

    boolean addAll(Collection c) - 합집합
    boolean removeAll(Collection c) - 교집합
    boolean retainAll(Collection c) - 차집합
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9_HashSet {
    public static void main(String[] args) {
        Object[] objArr = {"1", 1, "2", "2", "3", "3", "4", "4", "4"};
        Set set = new HashSet();

        for(int i=0; i<objArr.length; i++) {
            set.add(objArr[i]); // HashSet에 objArr의 요소들을 저장
        }   // 중복된 값 저장X    , 순서 유지 -> LinkedHashSet 사용

        // HashSet에 저장된 요소들 출력
        System.out.println(set);

        // HashSet에 저장된 요소들을 출력 (Iterator 이용)
        Iterator it = set.iterator();   // iterator() : Iterator 인스턴스 반환

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
