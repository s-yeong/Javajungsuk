package org.chapter5;

import java.util.Arrays;

public class Ex5_7 {

    /**
     * String 클래스 주요 메서드
     * 1. char charAt(int index) : 문자열에서 해당 인덱스에 있는 문자를 반환
     * 2. int length() : 문자열의 길이를 반환
     * 3. String substring(int from, int to) : 문자열에서 해당 범위(from~to)의 문자열을 반환
     * 4. boolean equals(Object obj) : 문자열의 내용이 같은지 확인
     * 5. char[] toCharArray() : 문자열을 문자배열(char[])로 변환해서 반환
     */

    // 커맨드 라인을 통해 입력받기
    public static void main(String[] args) {
        System.out.println("매개변수 개수:"+args.length);
        Arrays.toString(args);

    }

}
