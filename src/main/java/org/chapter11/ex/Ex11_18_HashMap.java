package org.chapter11.ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 문자열들의 빈도수 구하기
// 한정된 범위 내에 있는 순차적인 갑들의 빈도수 -> 배열을 이용
// 한정되지 않은 범위의 비순차적인 값들의 빈도수 -> HashMap 이용
public class Ex11_18_HashMap {
    public static void main(String[] args) {
        String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

        HashMap map = new HashMap();

        for(int i=0; i<data.length; i++) {
            if(map.containsKey(data[i])) {  // 포함?
                int value = (int)map.get(data[i]);
                map.put(data[i], value + 1);    // 기존에 있는 키는 기존 값에 1을 더해서 저장
            } else {
                map.put(data[i], 1);    // 기존에 없는 키는 값을 1로 저장
            }
        }

        Iterator it = map.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int value = (int) entry.getValue();
            System.out.println(entry.getKey() + " : "
             + printBar('#',value) + " " + value);
        }
    }

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];
        for(int i=0; i<bar.length; i++) {
            bar[i] = ch;
        }
        return new String(bar);

    }
}


