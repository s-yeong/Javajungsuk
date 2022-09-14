package org.chapter11.ex;

import java.util.TreeSet;

public class Ex11_15_TreeSet {  // 범위 검색에 유리 -> subSet(), headSet(), tailSet()
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
        for(int i=0; i<score.length; i++) {
            set.add(score[i]);
        }
        // set.headSet(Object toElement) -> 지정된 객체보다 작은 값의 객체들을 반환 
        System.out.println("50보다 작은 값 : " + set.headSet(50));
        // set.tailSet(Object fromElement) -> 지정된 객체보다 큰 값의 객체들을 반환 (지정된 객체 포함)
        System.out.println("50보다 큰 값 : " + set.tailSet(50));    
    }

    /*
        트리 순회(tree traversal)
        이진 트리의 모든 노드를 한번씩 읽는 것을 트리 순회
        -> 중위 순회하면 오름차순으로 정렬된다. => 정렬에 유리
     */
}
