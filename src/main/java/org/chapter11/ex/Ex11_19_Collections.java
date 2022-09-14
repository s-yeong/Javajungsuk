package org.chapter11.ex;

/*
    Collections
    컬렉션과 관련된 메서드 제공 (static)    => 비슷한 것들 Objects, Arrays
    fill(), copy(), sort(), binarySerach() 등
    Collections는 클래스다! <-> Collection은 인터페이스!
 */

/*
    컬렉션의 동기화
    멀티 쓰레드 프로그래밍에서는 하나의 객체를 여러 쓰레드가 동시에 접근할 수 있기 때문에
    데이터의 무결성을 유지하기 위해서는 공유되는 객체의 "동기화"가 필요
    - Vector와 Hashtable과 같은 구버전의 클래스들은 자체적으로 동기화 처리가 되는데
    멀티쓰레드 프로그래밍이 아닌 경우에는 불필요한 기능이 되어 성능을 떨어뜨린는 요인이 된다
    => ArrayList, HashMap과 같은 컬렉션은 동기화를 자체적으로 처리하지 않고,
    필요한 경우에만 java.util.Collections클래스의 동기화 메서드를 이용해서 동기화 처리가 가능하도록 변경
    static Collection synchronizedCollection(Collection c)
    static List synchronizedList(List list)
    ... 등등

    사용 방법
    List syncList = Collections.synchronizedList(new ArrayList(...));
 */

/*
    변경불가 컬렉션 만들기
    컬렉션에 저장된 데이터를 보호하기 위해서 컬렉션을 변경할수 없게, "읽기전용"으로 만들어야 할 때
    주로 멀티 쓰레드 프로그래밍에서 여러 쓰레드가 하나의 컬렉션을 공유하다보면, 데이터가 손상될 수 있음
    이를 방지하기 위한 메서드
    static Collection unmodifiableCollection(Collection c)
    static List unmodifiableList(List list)
    ... 등등

    싱글톤 컬렉션 만들기
    단 하나의 객체만을 저장하는 컬렉션을 만들어야 하는 경우
    static List singletonList(Object o)
    static Set singleton(Object o) // singletonSet 아님
    static Map singletonMap(Object key, Object value)
    => 매개변수로 저장할 요소를 지정하면, 해당 요소를 지정하는 컬렉션을 반환!
    그리고 반환된 컬렉션은 변경할 수없음
 */

/*
    단일 컬렉션(한 종류의 객체만 저장하는 컬렉션)
    컬렉션에 지정된 종류의 객체만 저장할 수 있도록 제한하고 싶을 때
    static Collection checkedCollection(Collection c, Class type)
    static List checkedList(List list, Claa type)
    ... 등등

    사용 방법
    두 번째 매개변수에 저장할 객체의 클래스를 지정
    List list = new ArrayList();
    List checkedList = checkedList(list, String.class); // String만 저장가능!!
    checkedList.add("abc"); // 가능
    checkedList.add(3); // 에러!
 */


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static java.util.Collections.*;

public class Ex11_19_Collections {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        // Collections.addAll => list에 1,2,3,4,5 넣기 // 가변인자
        addAll(list, 1,2,3,4,5);
        System.out.println(list);

        // Collections.rotate => 오른쪽으로 2칸 이동 (반시계 방향으로 2번 회전)
        rotate(list, 2);
        System.out.println(list);

        // Collections.swap => 첫 번째와 세 번째를 교환
        swap(list, 0, 2);
        System.out.println(list);

        // Collections.shuffle => 저장된 요소의 위치 임의로 변경
        shuffle(list);
        System.out.println(list);

        // Collections.sort( , reverseOrder()) => 역순 정렬 reverse(list)와 동일
        sort(list, reverseOrder());
        System.out.println(list);

        // 정렬
        sort(list);
        System.out.println(list);

        // Collections.binarySearch => 3이 저장된 "위치"를 반환
        int idx = binarySearch(list, 3);
        System.out.println("idx = " + idx);

        System.out.println("max=" +max(list));
        System.out.println("min=" +min(list));
        System.out.println("min=" +max(list, reverseOrder()));

        // Collections.fill => 9로 채운다
        fill(list, 9);
        System.out.println("list = " + list);

        // Collections.nCopies() => list와 같은 크기의 새로운 list를 생성하고 2로 채운다
        // 결과는 변경불가!!
        List newList = nCopies(list.size(), 2);
        System.out.println("newList="+newList);

        // Collections.disjoint() => 공통요소가 없으면 true
        System.out.println(disjoint(list, newList));
        
        // Collections.copy() => list를 newList로 복사한다
        copy(list, newList);
        System.out.println("newList = " + newList);
        System.out.println("list = " + list);

        // Collections.replaceAll() => 2를 1로 바꾼다
        replaceAll(list, 2, 1);
        System.out.println("list = " + list);

        // iterator와 같은 거임 (자주 쓰이진 않음)
        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);

        System.out.println("list2 = " + list2);

    }



}
