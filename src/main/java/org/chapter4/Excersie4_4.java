package org.chapter4;

// for 문 생각해야할 것
// 조건식 맞을 경우 문장 수행하고 증감한다! -> "증감식 전의 조건"으로 문장이 수행된다!!!!!
public class Excersie4_4 {

    // 1 + (-2) + 3 + (-4) + ...
    public static void main(String[] args) {

        int sum = 0;    // 총 합을 저장할 변수
        int s = 1;      // 값의 부호를 바꿔주는데 사용할 변수
        int num = 0;    // 합할 수

        for(int i=1; sum<100; i++, s=-s) {
            num = i * s;
            sum += num;
        }

        System.out.println("num = " + num);
    }

}
