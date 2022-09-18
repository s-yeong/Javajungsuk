package org.chapter14.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Exercise14_6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
/*
        int max = Stream.of(strArr)
                .mapToInt(String::length)
                .max().getAsInt();
        System.out.println("max = " + max);
*/
        Arrays.stream(strArr)
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1).forEach(System.out::println);


        // 제일 긴 문자열 출력
        /*Arrays.stream(strArr)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .forEach(System.out::println);
*/
    }
}
