package org.chapter2;

public class Ex2_11 {

     /*
        1. 정수형의 오버플로우
        "최대값 + 1" -> "최소값" : 1111 + 1 -> 0000
        "최소값 - 1" -> "최대값" : 0000 - 1 -> 1111
     */

    /*
        2. 부호있는 정수의 오버플로우
        부호비트가 0에서 1이 될 때 오버플로우 발생
        4 bit인 경우 부호 없는 정수의 표현 범위 => 0~15가 반복
        부호 있는 정수의 표현 범위 => -8~7이 반복

        오버플로우 발생 1000 (-8) <-> 0111 (7)

     */

    public static void main(String[] args) {

        // "1byte = 8bit"
        // boolean : 1byte - true, false
        // char : 2byte - 0~2^16-1
        // byte : 1byte - -2^7 ~ 2^7-1
        // short : 2byte - -2^15 ~ 2^15-1
        // int : 4byte - -2^32 ~ 2^32-1 (약 20억)
        // long : 8byte - -2^63 ~ 2^63-1
        // float : 4byte -
        // double : 8byte

        short sMin = -32768,    sMax = 32767;   // -2^15 , 2^15-1
        char  cMin = 0,         cMax = 65535;   // 0, 2^15-1

        System.out.println("sMin = " + sMin);
        System.out.println("sMin-1 = " + (short)(sMin-1));
        System.out.println("sMax = " + sMax);
        System.out.println("sMax+1 = " + (short)(sMax+1));

        System.out.println("cMin = " + (int)cMin);
        System.out.println("cMin-1 = " + (int)--cMin);
        System.out.println("cMax = " + (int)cMax);
        System.out.println("cMax+1 = " + (int)++cMax);

    }

}
