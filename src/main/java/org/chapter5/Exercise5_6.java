package org.chapter5;

import java.util.Scanner;

public class Exercise5_6 {

    // 단어의 글자 위치를 섞어서 보여주고 원래의 단어를 맞추는 예제
    public static void main(String[] args) {

        String[] words = {"television", "computer", "mouse", "phone"};

        Scanner scanner = new Scanner(System.in);


        for(int i = 0; i <words.length; i++) {

            char[] question = words[i].toCharArray();
            // char[] toCharArray() : 문자열을 문자배열(char[])로 변환해서 반환

            for(int j = 0; j<question.length; j++ ) {
            // 섞기
                int x = (int) (Math.random() * question.length);

                char tmp = question[i];
                question[i] = question[x];
                question[x] = tmp;
            }
            System.out.printf("Q%d. %s의 정답을 입력하세요.>",
                    i+1, new String(question)); // String 객체로 생성

            String answer = scanner.nextLine();

            // trim()으로 answer의 좌우 공백 제거, equals로 word[i]와 비교
            if(words[i].equals(answer.trim())){
                System.out.println("맞았습니다.");
            }
            else {
                System.out.println("틀렸습니다.");
            }

        }



    }



}
