package org.chapter11.ex;

import java.util.TreeSet;

public class Ex11_14_TreeSet {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();    // 범위 검색에 유리. from~to

        String from = "b";
        String to = "d";

        set.add("abc");      set.add("alien");    set.add("bat");
        set.add("car");      set.add("Car");      set.add("disc");
        set.add("dance");    set.add("dZZZZ");    set.add("dzzzz");
        set.add("elephant"); set.add("elevator"); set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.println("range search from " + from + " to " + to);
        // subSet()을 이용해서 범위 검색
        System.out.println("result1 : " + set.subSet(from,to));  // b부터 d 전까지
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));    // b부터 dzzz 전까지

        // 대문자가 소문자보다 우선 -> 대소문자가 섞여 있는 경우 의도한 것과는 다른 범위검색결과를 얻을 수 있음
    }
}
