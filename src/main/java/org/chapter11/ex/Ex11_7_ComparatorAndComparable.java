package org.chapter11.ex;

import java.util.Arrays;
import java.util.Comparator;

/*
    Comparator, Comparable
    "인터페이스"로 "컬렉션을 정렬"하는데 필요한 메서드를 정의하고 있음
    정렬 -> 1. 두 대상 비교 2. 자리 바꿈

    => !!정렬 기준!!을 제공한다
    Comparable(기본 정렬기준 - 오름차순)
    구현하고 있는 클래스 - 같은 타입의 인스턴스끼리 서로 비교할 수 있는 클래스들,
    주로 Integer와 같은 wrapper 클래스와 String, Data, File과 같은 것들이며
    기본적으로 "오름차순"으로 구현되어 있다. => Comparable을 구현한 클래스는 정렬이 가능하다는 것을 의미
    
    Comparator
    => 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용

    public interface Comparable {
        int compareTo(Object o); // 객체 자신(this)와 o 비교
        // 두 객체가 같으면 0, 값보다 작으면 음수, 크면 양수를 반환
    }
    public interface Comparator {
        int compare(Object o1, Obejct o2); // o1과 o2 비교
        // -> comareTo와 마찬가지로 객체를 비교해서 음수, 0, 양수 중의 하나를 반환하도록 구현
        boolean equals(Object obj); // 오버라이딩이 필요할 수도 있기에 정의
    }

    ex) Intger extends Number implements Comparable {
    public int comareTo(Integer anotherInteger) {



 */
class Ex11_7_ComparatorAndComparable {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);    // String의 Comparable 구현에 의한 정렬
        // Arrays.sort()는 배열을 정렬할 때, Comparator를 지정해주지 않으면,
        // 저장하는 객체(Comparable을 구현한 클래스의 객체 - String)에 구현된 내용에 따라 정렬된다.
        System.out.println("strArr=" + Arrays.toString(strArr));
        // => String의 Comparable 구현은 문자열이 사전 순으로 정렬되도록 작성되어 있다
        //      문자열의 오름차순 정렬은 공백, 숫자, 대문자, 소문자의 순으로 정렬되는 것을 의미(유니코드 순)

        // 정렬 -> 정렬 대상, 정렬 기준이 있어야함
        // static void sort(Object[] a) -> 객체 배열에 저장된 객체가 구현한 Comparable에 의한 정렬
        // static void sort(Object[] a, Comparator c) -> 지정한 Comparator에 의한 정렬

        // Arrays.sort(정렬 대상, 정렬 기준)
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);   // 대소문자 구분안함
        // 대소문자를 구분하지 않고 비교하는 Comparator를 상수의 형태로 제공 => public static final Comparator CASE_INSENSITIVE_OREDER
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());  // 역순 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

    }
}

class Descending implements Comparator {
    public int compare(Object o1, Object o2) {

        // 참조변수의 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof 연산자를 사용한다.
        // => instatnceof가 true면 참조변수가 검사한 타입으로 형변환이 가능하다는 뜻이다.
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;   // -1을 곱해서 기본 정렬방식의 역으로 변경
            // 양수 -> 음수, 음수 -> 양수       => 내림차순
            // return c2.compareTo(c1)
        }
        return -1;
    }
}