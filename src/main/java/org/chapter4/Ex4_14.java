package org.chapter4;

import java.util.Scanner;

public class Ex4_14 {

    // 임의의 정수 만들기 : Math.random()
    // 0.0 <= Math.random() < 1.0

    // while문 예제
    public static void main(String[] args) {

        int num = 0, sum = 0;
        System.out.print("숫자 입력>");

        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        num = Integer.parseInt(temp);

        // -> 어떤 수를 10으로 나머지 연산하면 마지막 자리를 얻을 수 있다.
        // -> 10으로 나누면 마지막 자리가 된다.
        while(num != 0) {
            // num을 10으로 나눈 나머지를 sum에 더하기
            sum += num%10;
            System.out.printf("sum=%3d num=%d%n",sum,num);

            num /= 10;  // num을 10으로 나눈 값을 다시 저장

        }

        System.out.println("각 자리수 합: " + sum);

    }
}
