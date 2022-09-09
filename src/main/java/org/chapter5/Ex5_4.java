package org.chapter5;

import java.util.Arrays;

public class Ex5_4 {

    // Arrays.toString(배열이름) - 배열의 모든 요소를 [첫번째 요소, 두번째 요소, ...] 와 같은 형식의 문자열로 만들어서 반환
    // char 배열은 println 메서드로 출력하면 각 요소가 구분자 없이 그대로 출력됨
    // ex) char[] chArr = {'a','b','c'} => abc
    public static void main(String[] args) {

        int[] numArr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(numArr));

        // Math.random() 사용
        for(int i = 0; i < 100; i++) {

            // 0~9까지 항들 값들 중에서 섞기
            int n = (int)Math.random() * 10;
            int tmp = numArr[0];
            numArr[0] = numArr[n];
            numArr[n] = tmp;

        }
        System.out.println(Arrays.toString(numArr));

        
    }
}
