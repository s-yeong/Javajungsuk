package org.chapter5;

import java.util.Scanner;

/**
 * Arrays 클래스 주요 메서드
 * 1. 배열의 비교와 출력 - equals(), toString() - 배열의 모든 요소를 문자열로 편하게 출력
 * deepToString() - 다차원 배열 출력 (재귀적으로 접근), deepEquals() - 다차원 배열
 * 2. 배열의 복사 - copyOf() -> 배열 전체 , copyOfRange() -> 배열의 일부를 복사 (범위의 끝 포함 X)
 * Arrays.copyOf(arr, 3) Arrays.copyOfRange(arr, 2, 4)
 * 3. 배열의 정렬 - sort()
 * Arrays.sort(arr)
 */


public class Ex5_10 {
    public static void main(String[] args) {
        String[][] words  = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "정수"}
        };

        Scanner scanner = new Scanner(System.in);

        for(int i =0; i<words.length; i++) {

            System.out.printf("%s의 뜻?",words[i][0]);
            String keyword = scanner.nextLine();
            if(keyword.equals(words[i][1])) {
                System.out.println("정답입니다.");
            }
            else {
                System.out.printf("틀렸습니다. %s입니다.%n", words[i][1]);
            }


        }



    }
}
