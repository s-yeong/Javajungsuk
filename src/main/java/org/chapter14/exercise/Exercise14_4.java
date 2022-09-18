package org.chapter14.exercise;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 어려움!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */

public class Exercise14_4 {
    public static void main(String[] args) {

/*
        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        for(int i=0; i<dice1.length; i++) {
            for(int j=0; j< dice2.length; j++) {
                if(dice1[i] + dice2[j] == 6) {
                    System.out.printf("[%d, %d]%n",dice1[i],dice2[j]);
                }
            }
        }
*/


        // 두 개의 주사위 -> 배열 2개 필요 -> 배열에 두 배열을 넣는 방식
        // -> Stream<int[]> 형태로 변환 필요! - flatMap

        // 스트림 만들기 - 특정 범위의 정수
        // IntStream과 LongStream은 지정된 범위의 연속된 정수를 스트림으로 생성해서 반환하는
        // range()와 rangeClosed()가 있음
//        IntStream intStream = IntStream.rangeClosed(1, 6);

        // map, flatmap 이용하려면 boxed() 해야한다 !!!
        Stream<Integer> die = IntStream.rangeClosed(1, 6).boxed();

        // 1,2,3,4,5,6 이 있는 스트림을 하나 더 생성후
        // Stream<Integer>인 die를 -> Stream<Int[]>
        Stream<int[]> dieStream = die
                .flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i, i2}));
                                // Integer -> Stream<int[]>

        dieStream
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));


    }
}
