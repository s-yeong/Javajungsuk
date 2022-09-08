package org.algorithm;

public class Problem {

    /**
     * 문제 1
     * N 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수 func1(int N) 작성
     * N은 10만 이하의 자연수
     * ex) func1(16) = 60
     */

    // 시간 복잡도 -> 1부터 N까지 돌면서 3으로 나눠지는지 5로 나눠 지는 지 확인 -> O(N)
    public static int func1(int N) {

        int sum = 0;
        for (int i = 1; i <= N; i++) {

            /*if (i % 3 == 0 && i % 5 == 0)
                sum += i;
            else if (i % 3 == 0)
                sum += i;
            else if (i % 5 == 0)
                sum += i;*/

            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }

        }
        return sum;
    }

    /**
     * 문제 2
     * 주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을,
     * 존재하지 않으면 0을 반환하는 함수 func2(int arr[], int N)을 작성하라.
     */

    // 시간 복잡도는 i가 0일 때 N-1개의 수와 합이 100이 되는 것을 비교, i가 1일 때 N-2개의 수와 비교...
    // (N-1) + (N-2) + ... 1  = (N^2-N)/2, O(N^2)

    public static int func2(int arr[], int N) {

        /*for(int i = 0; i < N; i++) {
            for(int j  = 0; j < N; j++) {
                if(arr[i] != arr[j]) {
                    if (arr[i] + arr[j] == 100)
                        return 1;
                }
            }
        }*/

        for(int i = 0; i < N; i ++) {
            for(int j = i+1; j < N; j++) {
                if(arr[i] + arr[j] == 100)
                    return 1;
            }
        }
        return 0;
    }

    /**
     * 문제 3
     * N이 제곱수이면 1을 반환, 제곱수가 아니면 0을 반환하는 함수 func3(int N)
     * N은 10억 이하의 자연수
     */

    // 시간 복잡도 - O(루트N)
    // i가 1부터 올라가면서 1의 제곱이 N과 일치하는지.. 2의 제곱이 N과 일치하는지..
    public static int func3(int N) {

        for(int i = 1; i*i <= N; i++ ) {
            // i를 N까지 돌릴 필요가 없다. i*i 까지만 돌리면 된다! i가 N일 때 N*N까지 돌리는건데 의미없음 (1부터 루트N까지 올라가게 된다)
            if(i * i == N) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 문제 4
     * N 이하의 수 중에서 가장 큰 2의 거듭제곱 수를 반환하는 함수 func4(int N)을 작성하라
     * N은 10억 이하의 자연수
     */

    // N이 2^k 이상 2^l+1 미만이라고 할 때,
    // while문 안에서 value는 최대 K번 2배 커짐
    // 시간 복잡도 -> O(k) = O(logN)

    public static int func4(int N) {

       /* int max;
        for(int i=N; i>=1; i--) {
            max = N;
            while(max % 2 == 0){
                max = max/2;
            }
            if(max == 1) {
                return N;
            }
        }*/

        int val = 1; // 2의 거듭 제곱이 저장되는 변수

        while(2 * val <= N) {
            val *= 2;
        }
        return val;

    }


    public static void main(String[] args) {

        System.out.println(func1(27639));
        System.out.println(func2(new int[]{4, 13, 63, 87},4));
        System.out.println(func3(756580036));
        System.out.println(func4(5));

    }





}
