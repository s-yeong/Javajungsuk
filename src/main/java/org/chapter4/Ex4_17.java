package org.chapter4;

public class Ex4_17 {

    // contunue문 예제
    public static void main(String[] args) {
        for(int i = 0; i <= 10 ; i++) {
            if(i%3 == 0) {
                continue;   // continue 문 수행 -> 블럭의 끝
            }
            System.out.println(i);
        }
    }

}
