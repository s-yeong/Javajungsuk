package org.chapter6.exercise;

import java.util.Arrays;

public class Exercise6_20 {

    static int max(int[] arr) {
        // 주어진 int형 배열의 값 중에서 제일 큰 값 반환
        // null이나 0인 경우, -999999 반환

        if(arr == null || arr.length == 0) {
            return -999999;
        }

        int maxN = arr[0];

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] > maxN) {
                maxN = arr[i];
            }
        }
        return maxN;
    }

    public static void main(String[] args) {

        int[] data = { 3, 2, 9, 4, 7 };
        System.out.println(Arrays.toString(data));
        System.out.println("최대값:" + max(data));
        System.out.println("최대값:" + max(null));
        System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
    }
}
