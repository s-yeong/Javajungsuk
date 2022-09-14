package org.chapter11.ex;


import java.util.Arrays;
import java.util.Comparator;

/*
    정렬할 때는 항상 "기준"이 필요
    Arrays.sort()로 정렬할 때 아무런 정렬 기준을 주지 않았는데도 정렬이 되는 이유는
    배열 arr에 저장된 Integer가 내부에 정렬 기준을 가지고 있기 때문
    - Arrays.sort(arr); // Intger가 가지고 있는 기본 정렬 기준 compareTo()로 정렬
    => 정렬 기준을 매개변수로 제공하던지, 정렬 대상에 저장된 객체가 정렬기준을 가지고 있어야함!!

    - 이 때 정렬 기준은 양수, 0, 음수 중에서 하나를 반환하는 메서드이기에
    -1을 곱하기만 하면 반대로 정렬된 결과를 얻을 수 있다!

    두 대상 비교하는 부분만 바꾸면 되지, 자리 바꿈하는 부분은 바꿀 필요 없음
    => 정렬 기준만 주면 작성해주면 됨(정렬 방법의 로직은 안바뀜)

 */
public class Ex11_8_ComparatorAndComparable {
    public static void main(String[] args) {
        Integer[] arr = {30, 50, 10, 40, 20};

        Arrays.sort(arr);   // Intger가 가지고 있는 기본 정렬 기준 compareTo()로 정렬
        System.out.println(Arrays.toString(arr));

        // sort(Object[] objArr, Comparator c)
        Arrays.sort(arr, new DescComp());
        System.out.println(Arrays.toString(arr));

    }

}

class DescComp implements Comparator {
    
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof Integer && o2 instanceof Integer)) {
            return -1; // Intger가 아니면, 비교하지 않고 -1 반환
        }

        Integer i = (Integer)o1;
        Integer i2 = (Integer)o2;
        return i.compareTo(i2) * -1; // 기본 정렬 역순으로

    }
}
