package org.chapter14.ex;

/*
    컬렉션 플레임워크의 인터페이스에 일부는 함수형 인터페이스를 사용
    Collection은 Iterable을 상속한다
    모든 컬렉션은 forEach(Consumer<T> action) 메서드 사용 가능
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex14_4_CollectionMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++)
            list.add(i);
        
        // forEach -> 모든 요소에 작업()를 수행
        list.forEach(i -> System.out.print(i + ","));
        System.out.println();
        // 편리해졌다!
        // Iterator it = list.iterator(); 한다음 while(it.hasNext){ System.out.println(it.next);

        // removeIf -> 조건에 맞는 요소 삭제 (list에서 2 또는 3의 배수 제거)
        list.removeIf(x -> x%2 == 0 || x%3==0);
        System.out.println(list);

        // replaceAll -> 모든 요소를 변환하여 대체
        list.replaceAll(i -> i*10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // forEach -> 모든 요소에 작업 수행 (map의 모든 요소를 {k,y} 형식으로 출력)
        map.forEach((k,v) -> System.out.print("{" + k + "," + v + "},"));
        System.out.println();
    }
}
