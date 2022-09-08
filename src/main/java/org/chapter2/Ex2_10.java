package org.chapter2;

import java.util.Scanner;

public class Ex2_10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int num = Integer.parseInt(input);  // 문자열 int 타입의 정수로 반환
//        int num2 = scanner.nextInt();

        System.out.printf("num=%d%n", num);
        // %n 대신 \n을 사용해도 되지만, OS마다 줄바꿈 문자가 다를 수 있음

        String str = "3";
        // 1. 숫자를 문자로 변환 - 숫자에 '0'을 더한다
        char num3 = (char)(3 + '0');
        // 2. 문자를 숫자로 변환 - 문자에서 '0'을 뺀다
        char num4 = '3' - '0';
        // 3. 숫자를 문자열로 변환 - 숫자에 빈 문자열("")을 더한다
        String num5 = 3 + "";
        // 4. 문자열을 숫자로 변환 - Integer.parseInt(), Double.parseDouble() 사용
        double num6 = Double.parseDouble("3.14");
        // 5. 문자열을 문자로 변환 - charAt(0)을 사용한다
        char num7 = "3".charAt(0);
        // 6. 문자를 문자열로 변환 - 빈 문자열("")을 더한다
        String num8 = '3' + "";


    }


}
