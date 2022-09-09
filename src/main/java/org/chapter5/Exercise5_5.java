package org.chapter5;

public class Exercise5_5 {
    public static void main(String[] args) {

        // 1과 9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자
        int[] ballArr = {1,2,3,4,5,6,7,8,9};
        int[] ball3 = new int[3];

        // ballArr의 임의의 요소 골라서 위치 바꿈
        for(int i = 0; i < ballArr.length; i++) {
            int j = (int)(Math.random() * ballArr.length);
            int tmp = 0;

            tmp = ballArr[i];
            ballArr[i] = ballArr[j];
            ballArr[j] = tmp;

        }

        // ballArr 앞에 3개의 수 배열 복사
//        ball3 = Arrays.copyOfRange(ballArr, 0, 3);
        // 만약 범위가 0,4이면 배열의 length 4로 증가

        System.arraycopy(ballArr, 0, ball3, 0, 3);
        // ballArr[0] 에서 ball3[0]으로 3개의 데이터 복사

        for(int i = 0 ; i<ball3.length; i++) {
            System.out.print(ball3[i]);
        }

    }
}
