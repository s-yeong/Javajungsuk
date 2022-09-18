package org.chapter14.exercise;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

/*
        int sum = 0;
        for(int i=0; i< strArr.length; i++) {
           sum += strArr[i].length();
        }
        System.out.println(sum);
*/
        int sum = Arrays.stream(strArr)
                .mapToInt(String :: length)
                .sum();
        System.out.println("sum = " + sum);
/*
        Integer sum2 = Stream.of(strArr)
                .map(String::length)
                .reduce(0, (a, b) -> Integer.sum(a, b));
        System.out.println("sum2 = " + sum2);
*/
    }
}
