package org.chapter3;

public class Exercise3_6 {
    public static void main(String[] args) {
        int fahrenheit = 100;

        // 셋째자리에서 반올림
        float cecius = (int)((5/9f * (fahrenheit-32))*100 + 0.5)/100f;

        System.out.println("fahrenheit = " + fahrenheit);
        System.out.println("cecius = " + cecius);

    }
}
