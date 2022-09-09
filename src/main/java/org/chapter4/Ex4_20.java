package org.chapter4;

import java.util.Scanner;

public class Ex4_20 {

    // break문은 "하나"의 반복문만 벗어난다 -> 중첩 반복문을 완전히 벗어날 수는 X
    // 이름 붙은 반복문은 하나 이상의 반복문을 벗어나거나 건너뛸 수있다!!
    public static void main(String[] args) {

        int menu = 0;
        int num = 0;

        Scanner scanner = new Scanner(System.in);

        outer : while(true) {   // while문에 outer라는 이름을 붙임

            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");
            System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0)>");

            String temp = scanner.nextLine();
            menu = Integer.parseInt(temp);

            if(menu == 0) {
                System.out.println("종료하겠습니다.");
                break;
            }
            else if(!(menu>=1 && menu <=3)) {
                System.out.println("잘못 선택하였습니다.");
                continue;
            }

            for(;;) {
                System.out.println("계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>");
                temp = scanner.nextLine();
                num = Integer.parseInt(temp);

                if(num==0)
                    break;  // for문 벗어남
                if(num==99)
                    break outer;    // for문과 while문 모두 벗어남

                switch(menu) {

                    case 1:
                        System.out.println("result=" + num*num);
                        break;
                    case 2:
                        System.out.println("result=" + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result=" + Math.log(num));
                        break;
                }
            }

        }

    }

}
