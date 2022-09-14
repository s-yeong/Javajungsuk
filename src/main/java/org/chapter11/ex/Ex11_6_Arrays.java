package org.chapter11.ex;
import java.util.*;
/*
    Arrays
    배열을 다루는데 유용한 메서드가 정의되어 있음
    - static 메서드    (Math, Objects, Collections)
    - 모든 기본형 배열과 참조형 배열 별로 하나씩 정의

    - 일차원 배열 - toString() - 배열의 "모든 요소를 문자열로 편하게 출력"    (오버로딩 되어있음)
    - 다차원 배열 - deppToSTring() - 배열의 모든 요소를 재귀적으로 접근해서 문자열을 구성

    - 배열의 복사 - copyOf(배열, 크기) -> 배열 전체(앞부터),   copyOfRange(배열, from, to) -> 배열의 일부를 복사해서 새로운 배열 반환
    -> 없는 나머지 부분은 0으로 채움

    - 배열 채우기 - fill(배열, 값) -> 배열의 모든 요소를 지정된 값으로 채움,
    - setAll(배열, 배열을 채우는데 사용할 함수형 인터페이스) -> 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받음

    - 배열 정렬 - sort()
    - 배열의 저장된 요소 검색(이진 탐색) - binarySearch(배열, 인덱스)  -> 지정된 값의 저장된 위치를 반환 - 반드시 "정렬"되어 있어야한다!!
    (검색한 값과 일치하는 요소들이 여러개 있다면, 어떤 것의 위치가 반환될지는알 수 없다.)
    이진 검색은 10을 찾는다 했을 때 반을 잘라서 계속 비교하는 방식이다.

    - 배열읠 List로 변환  => Arrays.asList(Object... a) - 가변 매개변수(갯수가 정해지지X)
    -> 읽기 전용이기에 크기 변경 불가
    -> 크기 변경 하라면 new ArrayLsit(Arrays.asList(1,2,3,4,5))    => 새로운 ArrayList를 만든다
 */
class Ex11_6_Arrays {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {{11, 12, 13}, {21, 22, 23}};

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arr2D = " + Arrays.deepToString(arr2D));

        // 배열 전체 복사 -> Arrays.copyOf(배열, 크기)
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);
        int[] arr4 = Arrays.copyOf(arr, 7);
        // 배열 일부 복사 -> Arrays.copyOfRange(배열, from, to) 범위 끝 포함X
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("arr6 = " + Arrays.toString(arr6));

        int[] arr7 = new int[5];
        // 모든 요소를 지정된 값으로 채움 -> Arrays.fill(배열,지정된 값)
        Arrays.fill(arr7, 9);   // arr=[9,9,9,9,9]
        System.out.println("arr7 = " + Arrays.toString(arr7));

        // 1~6 범위에 속한 임의의 정수 반환
        // Arrays.setAll(배열, 배열을 채우는데 사용할 함수형 인터페이스)
        // => 이 메서드를 호출 할 때는 함수형 인터페이스를 구현한 객체를 매개변수로 지정하거나
        // 람다식을 지정해야한다. => 람다식이 반환한 임의의 정수로 배열을 채운다.
        Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        System.out.println((int)(Math.random()*6));

        for(int i : arr7) {     // 향상된 for문 => for(int x=0; x<arr7.length; x++) { int i = arr7[x]
            char[] graph = new char[i];
            // graph 배열의 모든 요소를 '*'로 채운다
            Arrays.fill(graph,'*');
            System.out.println(new String(graph) + i);
            // char[] -> String : 배열을 String으로 바꾸기 위해서 생성자 사용
            // String -> char[] : toCharArray() 사용  => String str; str.toCharArray()
        }

        
        String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        // 일차원 배열 비교
        // 다차원 배열은 '배열의 배열' 형태로 구성하기 때문에,
        // eqquals()로 비교하면, 문자열을 비교하는 것이 아니라 '배열에 저장된 배열의 주소'를 비교
        System.out.println(Arrays.equals(str2D, str2D2));
        // 다차원 배열 비교
        System.out.println(Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println("chArr = " + Arrays.toString(chArr));
        // 정렬하지 않아서 잘못된 결과 나옴
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
        System.out.println("= After sorting =");
        // 배열 정렬
        Arrays.sort(chArr);
        System.out.println("chArr = " + Arrays.toString(chArr));
        // 정렬한 후라서 올바른 결과 나옴
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
    }

}
