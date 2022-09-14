package org.chapter11.ex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    Iterator, ListIterator, Enumeration(구버전)
    "컬렉션"에 저장된 데이터를 접근하는데 사용하는 인터페이스 - 표준화!

    - Collection 인터페이스에는 Iterator를 구현한 클래스의 인스턴스를 반환하는 iterator()를 정의함
    public interface Iterator {
        boolean hasNext();  // 1. 확인
        Object next();      // 2. 읽기
        void remove();
    }

    public interface Collection {
        public Iterator iterator();
        // Collection 인터페이스에 정의된 메서드 -> List와 Set에도 포함되어 있음
    }

    => 컬랙션 클래스에 대해 iterator()를 호출하여 Iterator를 얻은 다음,
    반복문, 주로 while문을 사용해서 컬렉션 클래스의 요소들을 읽어올 수 있다.

    List 클래스들은 저장순서를 유지하기 위해 Iterator를 이용해서 읽어 온 결과
    역시 저장순서와 동일하지만 Set 클래스들은 각 요소간의 순서가 유지 되지 않기 때문에
    Iterator를 이용해서 저장된 요소들을 읽어 와도 처음에 저장된 순서와 같지 않다!

    ListIterator는 next() 뿐만아니라 previous()도 있다 - 잘안씀
 */
public class Ex11_5_Iterator {
    public static void main(String[] args) {

        // 다른 컬렉션으로 변경할 때는 이 부분만 고치면 된다.
        Collection list = new ArrayList();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();

        // boolean hashNext() -> 읽어올 요소가 있는지 확인
        while(it.hasNext()) {
            // Object next() -> 다음 요소를 읽어옴
            Object obj = it.next();
            System.out.println(obj);
        }   // iterator를 다 쓰고나서 다시 읽으려면 다시 들고와야함 (1회용임)

        // <-> 동일 문장
        // list.size() 메소드를 계속 호출할게 아니라, final int SIZE = list.size();로 지정해준다
//        for(int i=0; i<list.size(); i++) {
//            Object obj = list.get(i);
//            System.out.println(obj);
//        }

    }
}



/*
    Map 인터페이스를 구현한 컬렉션 클래스는 key, value를 쌍으로 저장하고 있기 때문에
    iterater()를 직접 호출할 수 없고, keySet()이나 entrySet()과 같은 메서드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어 온 후
    다시 iterater()를 호출해야 Iterator를 얻을 수 있다.

    Map map = new HashMap();
    Iterator it = map.entrySet().iterator();
 */

