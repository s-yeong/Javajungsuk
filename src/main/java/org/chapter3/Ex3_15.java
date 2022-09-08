package org.chapter3;

import java.util.Scanner;

public class Ex3_15 {

    // 기본형, 참조형(객체의 주소값 저장) -> 등가비교 연산 (==, !=)
    // 문자열 - 문자열의 "내용"이 같은지 비교 -> equals(),
    // equals()는 객체가 달라도 내용이 같으면 true (==은 객체까지 같아야 true)

    // + 조건 연산자 : (x>y) ? x:y;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char ch = ' ';
        System.out.print("문자를 하나 입력하세요>");

        String input = scanner.nextLine();
        ch = input.charAt(0);

        if(ch >= '0' && ch <= '9') {
            System.out.println("숫자입니다.");
        }

        if(ch >= 'a' && ch <= 'z') {
            System.out.println("소문자입니다.");
        }

        if(ch >= 'A' && ch <= 'Z') {
            System.out.println("대문자입니다.");
        }

        // + 조건 연산자 : (x>y) ? x:y;
        int x = 5, y = -5;
        int result = (x > y) ? x:y;
        System.out.println(result);


    }

}
