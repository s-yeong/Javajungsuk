package org.chapter6.exercise;

public class Exercise6_18 {

    static boolean isNumber(String str) {
        // 주어진 문자열이 모두 숫자로만 이루어져있는지 확인
        // 모두 숫자 - true, 그렇지 않으면 false
        // 주어진 문자열 null, "" - false

        if(str == null || str.equals("")) {
            return false;
        }

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {

            if(!(chars[i] >= '0' && chars[i] <= '9')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + " 숫자? " + isNumber(str));

        str = "1234o";
        System.out.println(str + " 숫자? " + isNumber(str));
    }
}
