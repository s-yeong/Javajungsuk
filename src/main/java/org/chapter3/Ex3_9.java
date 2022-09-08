package org.chapter3;

public class Ex3_9 {

    /*
    피연산자의 타입이 int보다 작은 타입이면 int로 변환된다. => 연산 중에 오버플로우가 발생할 가능성이 높기 떄문에
    byte + byte -> int, byte + short -> int + int, char + short -> int + int
     */

    public static void main(String[] args) {
        int a = 1_000_000;
        int b = 2_000_000;

        long c = a * b; // int 타입 * int 타입 = int 타입이기 때문에 log 형으로 자동 형변환 되지 않는다!
        // => 오버 플로우 발생!!!!

        // 올바른 값 출력 : c = (long) a * b;
        System.out.println(c);  // -1454759936

    }


}
