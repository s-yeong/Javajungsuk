package org.chapter11.ex;

import java.util.Set;
import java.util.TreeSet;

/*
    TreeSet(범위 검색과 정렬에 유리)  <-> HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
    이진 탐색 트리(binary search tree)로 구현
    데이터를 저장하는 컬렉션 클래스
    이진 탐색 트리 - 정렬, 검색, 범위검색에 높은 성능을 보이는 자료구조

    TreesSet은 이진 탐색 트리의 성능을 향상시킨 '레드-블랙 트리'로 구현되어 있음
    - 중복된 데이터 저장 허용X, 저장 순서 유지X(정렬된 위치에 저장)

    이진 트리
    링크드 리스트처럼 여러 개의 노드가 서로 연결된 구조
    각 노드에 최대 2개의 노드를 연결할 수 있음
    루트(root)라고 불리는 하나의 노드에서부터 시작해서 계속 확장해 나갈 수 있음
    부모 - 자식관계는 상대적인 것, 하나의 부모 노드는 최대 두 개의 자식 노드와 연결될 수 있음
    (이진 탐색 트리는 이진 트리의 한 종류)

    이진 트리 코드
    class TreeNode {
        TreeNode left;  // 왼쪽 자식노드
        Object element; // 객체를 저장하기 위한 참조변수
        TreeNode right; // 오른쪽 자식노드
    }

    이진 탐색 트리(binary search tree)
    부모노드의 왼쪽에는 부모노드의 값보다 작은 값의 자식노드를
    오른쪽에는 큰 값의 자식노드를 저장하는 이진 트리

    "왼쪽 노드 -> 부모 노드 -> 오른쪽 노드" 순으로 읽어오면 => "오름차순"으로 정렬된 순서를 얻을 수 있음
    => 정렬된 상태를 유지하기 때문에 단일 값 검색과 범위 검색, ex) 3과 7사이의 범위에 있는 값을 검색이 빠름
    
    - 트리는 데이터를 순차적으로 저장하는 것이 아니라 저장위치를 찾아서 저장해야하고,
    삭제 하는 경우 트리의 일부를 재구성해야 하므로 링크드 리스트보다 "데이터의 추가/삭제시간은 더 걸림"
    => 배열이나 링크드 리스트에 비해 검색과 정렬기능이 더 뛰어남
    
    첫 번째로 저장되는 값은 루트가 된다
    왼쪽 마지막 레벨이 제일 작은 값, 오른쪽 마지막 레벨이 제일 큰 값
    => 비교하려면 Comparable을 구현하던지, Comparator를 제공해서 두 객체를 비교할 방법을 알려줘야 한다!

    데이터 저장 과정 -> boolean add(Object o)
    HashSet -> 1) equals(), 2) hashcode() 비교
    TreeSet -> 1) compare() 비교

 */
public class Ex11_13_TreeSet {
    public static void main(String[] args) {
        Set set = new TreeSet();    // 범위 검색, 정렬 (정렬필요X)

        for(int i=0; set.size()<6; i++) {
            // set 사이즈 6까지 저장
            int num = (int)(Math.random()*45) + 1;
            set.add(num);   // set.add(new Intger(num));
//            set.add(new Test());  -> 비교 기준이 없기 때문에 오류남
        }
        // TreeSet은 저장할 때 이미 정렬하기 때문에 따로 정렬할 필요가 없다.
        System.out.println(set);
    }
}

//class Test{}

// 비교 기준이 없는 경우
// => 저장하는 객체가  Comparable을 가지고 있던가, TreeSet 생성시 정렬기준을 가지던가