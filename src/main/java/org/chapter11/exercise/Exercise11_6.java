package org.chapter11.exercise;

import java.util.*;

// 빙고판 1~30 사이의 숫자들로 만든 것
// 숫자들의 위치 잘 섞이려면?
public class Exercise11_6 {
    public static void main(String[] args) {
        Set set = new HashSet();
        int[][] board = new int[5][5];

        for(int i=0; set.size() < 25; i++) {    // set 크기 25까지 만듬
            set.add((int) (Math.random() * 30) + 1 + ""); // 1~30까지 숫자들 (문자열 형태)
        }

        ArrayList list = new ArrayList(set);
        Collections.shuffle(list);

        Iterator it = list.iterator();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                board[i][j] =
                        Integer.parseInt((String) it.next());
                // it.next() 값은 Object다 => int로 타입변환 적절X => String => Int 변환
                System.out.print((board[i][j] < 10? " " : " ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
/*
    HashSet은 중복을 허용하지 않고, 순서를 유지하지 않기에 발생하는 문제!!!
    - 아무리 임의의 순서로 저장을 해도, 해싱 알고리즘의 특성상 한 숫자가 고정된 위치에 저장됨
    => 같은 값은 같은 자리에 저장됨 (빙고판의 숫자들이 잘 안섞임)

    해결 => 저장순서를 유지하는 List인터페이스를 구현한 컬렉션 클래스 사용
    ArrayList에 HashSet의 데이터 옮긴다음 shuffle!
 */

/**
 * 대부분 컬렉션 클래스들은 다른 컬렉션으로 데이터를 쉽게 옮길 수 있게 설계되어 있음
 */
