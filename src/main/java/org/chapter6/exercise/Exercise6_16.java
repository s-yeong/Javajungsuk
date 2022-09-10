package org.chapter6.exercise;

public class Exercise6_16 {

    public static void change(String str) { // 메서드의 change 지역 변수 str에 주소값 저장 ("ABC123" 참조)
        // 이 떄 두 참조변수는 이름은 같지만 다른 변수이다!!! (서로 다른 영역에서 존재하기에)
        str += "456";
        // 문자열은 내용을 변경할 수 없기 때문에 덧셈연산을 하면 새로운 문자열이 생성되고 새로운 문자열의 주소가 변수 str에 저장된다.
    }
    // 메서드가 종료되고 작업에 사용하던 메모리 반환 -> change 메서드의 지역변수인 str 역시 메모리에서 제거

    public static void main(String[] args) {

        String str = "ABC123";
        System.out.println(str);
        change(str);    // 참조변수 str 넘겨줌
        System.out.println("After change:" + str);
        // 처음의 값과 변함없는 값 출력

    }
}
