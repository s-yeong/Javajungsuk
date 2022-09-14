package org.chapter11.ex;

// 컬렉션 프레임워크 : 다수의 데이터를 저장하는 클래스들을 표준화한 설계

/**
 * 컬렉션 데이터 그룹 - 3개의 인터페이스
 * Collection (List, Set)
 * Map
 */

/*
    List
    데이터 순서 O, 중복 O
    구현클래스 - ArrayList, LinkedList, Stack, Vector

    Set (집합)
    데이터 순서 X, 중복 X
    구현클래스 - HashSet, TreeSet

    Map
    키(key) - 값(value)로 이루어진 데이터
    순서 X, 키는 중복 X, 값은 중복 O
    구현클래스 - HashMap, TreeMap
 */

public class Ex11_ {
}

/**
 * 컬렉션 클래스 정리 & 요약
 */

/*
    ArrayList(Vector) - 배열기반
    순차적인 추가 삭제는 빠르지만, 비순차적인 추가 삭제는 불리, 임의의 요소에 대한 접근성 뛰어남
    Stack - Vector를 상속받아 구현

    <->
    LinkedList - 연결기반
    데이터의 추가와 삭제에 유리, 임의의 요소에 대한 접근성 안좋음
    Queue - LinkedList가 Queue 인터페이스를 구현
    TreeMap - 연결기반, 정렬과 검색(특히, 범위검색)에 적합 (검색 성능은 HashMap보다 떨어짐)
    TreeSet - TreeMap을 이용하여 구현

    HashMap - 배열과 연결리스트 결합
    추가, 삭제, 검색, 접근성 모두 뛰어남 (검색에 최고!)
    Properties - HashMap 상속받아 구현, key value가 String이라 파일 읽기, 쓰기에 용이
    HashSet - HashMap을 이용해서 구현

    등등)
    LinkedHashMap, LinkedHashSet
    저장순서 유지기능 추가

 */
