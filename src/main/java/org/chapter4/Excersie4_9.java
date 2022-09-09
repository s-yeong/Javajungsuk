package org.chapter4;

public class Excersie4_9 {

    // 각 자리 합 더하기
    public static void main(String[] args) {

        int num = 12345;
        int sum = 0;

        while(num>0) {  // 숫자 자체가 0이될 때까지 돌리면 된다! - 계속 나누면 0이되니까

            sum += num % 10;
            num = num/10;
        }

        System.out.println("sum = " + sum);
    }
}
