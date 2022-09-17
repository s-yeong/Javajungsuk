package org.chapter14.ex;

/*
    Predicate의 결합 (default 메서드)
    여러 조건식을 논리 연산자인 && || !으로 연결해서 하나의 식을 구성할 수 있는 것처럼,
    여러 Predicate를 and(), or(), negate()로 연결해서 하나의 새로운 Predicate를 결합할 수 있다.
 */

import java.util.function.Function;
import java.util.function.Predicate;

public class Ex14_3_Prediacte { // 조건식
    public static void main(String[] args) {

        // 람다식을 하나로 연결시킬 수 있다!
        Function<String, Integer> f = s -> Integer.parseInt(s, 16); // 16진수로 해석해서 int로 바꿔라
        Function<Integer, String> g = i -> Integer.toBinaryString(i); // 2진수 문자열로 바꿔줌

        // 연결하려면 f의 출겨과 g의 입력이 같아야한다
        Function<String, String> h = f.andThen(g);  // 람다식 연결 f->g
        System.out.println(h.apply("FF"));  //"FF" -> 255 -> 11111111

        // 항등함수
        Function<String, String> f2 = x -> x;
        System.out.println(f2.apply("AAA"));    // 그대로 출력

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate();   // i >= 100

        Predicate<Integer> all = notP.and(q.or(r)); // i >=100 && (i < 200 || i%2 ==0)
        System.out.println(all.test(150));

        String str1 = "abc";
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1); // isEqual은 static 메서드
        boolean result = p2.test(str2); // str1.equals(str2)
        // 같은 문장
        // boolean result =  Predicate.isEqual(str1).test(str2);
        System.out.println(result);


    }
}
