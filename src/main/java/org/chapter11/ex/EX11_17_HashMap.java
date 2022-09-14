package org.chapter11.ex;

import java.util.*;

public class EX11_17_HashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김자바", 90);
        map.put("김자바", 100);    // 새로운 값으로 바뀜
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        // HashMap에 저장된 "키와 값"을 엔트리 형태로 Set에 저장해서 반환
        Set set = map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            // Map.Entry => Map 인터페이스 안에 정의되어 있는 또다른 Entry 인터페이스
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }
        
        // HashMap에 저장된 모든 "키"가 저장된 Set을 반환
        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        // HashMap에 저장된 모든 값을 컬렉션 형태로 반환
        Collection values = map.values();
        it = values.iterator();

        int total = 0;
        while(it.hasNext()) {
            int i = (int)it.next();
            total += i;
        }

        System.out.println("total = " + total);
        System.out.println("total = " + (float)total/set.size());
        // Collections에는 Comparable을 구현한 클래스 객체만 들어올 수 있음
        System.out.println("max values = " + Collections.max(values));
        System.out.println("min values = " + Collections.min(values));


    }
}
