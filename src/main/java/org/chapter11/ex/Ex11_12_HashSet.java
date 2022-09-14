package org.chapter11.ex;

import java.util.HashSet;
import java.util.Iterator;

public class Ex11_12_HashSet {
    public static void main(String[] args) {
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1");  setA.add("2");  setA.add("3");
        setA.add("4");  setA.add("5");
        System.out.println("setA = " + setA);

        setB.add("4");  setB.add("5");  setB.add("6");
        setB.add("7");  setB.add("8");
        System.out.println("setB = " + setB);

        Iterator it = setB.iterator();
        while(it.hasNext()) {
            Object tmp = it.next();
            if(setA.contains(tmp)) {
                setKyo.add(tmp);
            }
        }   // setA.retainAll(setB) - 교집합. 공통된 요소만 남기고 삭제

        it = setA.iterator();
        while(it.hasNext()) {
            Object tmp = it.next();
            if(!setB.contains(tmp)) {   // B에 없는 것만 저장
                setCha.add(tmp);
            }
        }   // setA.removeAll(setB) - 차집합. setB와 공통된 요소 제거

        it = setA.iterator();
        while(it.hasNext()) {
            setHab.add(it.next());
        }
        it = setB.iterator();
        while(it.hasNext()) {
            setHab.add(it.next());
        }   // setA.addAll(setB) - 합집합. setB의 모든 요소 추가(중복 제외)

        System.out.println("A ∩ B = " + setKyo);
        System.out.println("A ∪ B = " + setHab);
        System.out.println("A - B = " + setCha);
    }
}
