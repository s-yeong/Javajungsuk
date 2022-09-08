package org.chapter3;

public class Ex3_11 {

    
    // 반올림 시
    // Math.round() 사용 - 소수점 첫째 자리에서 반올림한 결과를 정수로 반환

    public static void main(String[] args) {

        double pi = 3.141592;
        double shortPi = Math.round(pi * 1000) / 1000.0;
        System.out.println("shortPi = " + shortPi);

    }
    
}
