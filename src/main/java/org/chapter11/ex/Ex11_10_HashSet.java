package org.chapter11.ex;

import java.util.*;

// 중복된 값을 저장하지 않는 HashSet 성질을 이용하여 로또번호를 만드는 예제
public class Ex11_10_HashSet {
    public static void main(String[] args) {
        Set set = new HashSet();

        for(int i=0; set.size()<6; i++) {   // 크기 6개까지
            int num = (int)(Math.random()*45) + 1;
            set.add(num);
        }

        List list = new LinkedList(set);    // LinkedList(Collection c)
        
        // 번호를 크기순으로 정려하기 위해 Collections 클래스 sort 사용
        // 이 메서드는 인자로 List인터페이스 타입을 필요
        // -> LinkedList에 객체들을 담아서 처리 
        Collections.sort(list); 
        // 정렬 기준은 컬렉션에 저장된 객체가 Integer이기 때문에,
        // Integer클래스에 정의된 기본정렬이 사용됨
        System.out.println(list);

        // Collections는 클래스다!! <-> Collection은 인터페이스다!!
    }
}
