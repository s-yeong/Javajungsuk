package org.chapter4;

import java.util.Scanner;

public class Exercise4_10 {

    // 숫자 맞히기 게임
    public static void main(String[] args) {

        int answer = (int)(Math.random()*100) + 1; // 1~100 임의의 값
        int input = 0;
        int count = 0;

        Scanner scanenr = new Scanner(System.in);

        while(true) {

            System.out.print("1~100사이 숫자 입력>");
            input = scanenr.nextInt();
            count++;

            if(input > answer) {
                System.out.println("더 작은 수를 입력하세요");
            }
            else if(input < answer) {
                System.out.println("더 큰 수를 입력하세요");
            }

            else {
                System.out.println("맞혔습니다.");
                System.out.println("시도횟수 : " + count);
                break;
            }

        }

    }
}
