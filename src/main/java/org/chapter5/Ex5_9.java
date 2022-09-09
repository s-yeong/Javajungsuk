package org.chapter5;

public class Ex5_9 {

    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100}
                , {20, 20, 20}
                , {30, 30, 30}
                , {40, 40, 40}
                , {50, 50, 50}
        };

        // 과목별 총점
        int korTotal = 0, engTotal = 0, mathTotal = 0;

        System.out.println("번호 국어 영어 수학 총점 평균");

        for(int i =0 ; i < score.length; i++) {
            int sum = 0;
            double avg = 0.0;

            korTotal += score[i][0];
            engTotal += score[i][1];
            mathTotal += score[i][2];
            System.out.printf("%3d", i+1);

            for(int j = 0 ; j < score[i].length; j++) {
                sum += score[i][j];
                System.out.printf("%5d", score[i][j]);
            }
            avg = (double)sum/score[i].length;

            System.out.printf("%5d %5.1f%n", sum, avg);

        }
        System.out.printf("총점:%3d %4d %4d%n", korTotal, engTotal, mathTotal);
    }

}
