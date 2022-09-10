package org.chapter6.ex;

/*
    메서드
    - 함수와 유사 (특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것)
    - 메서드는 "선언부"와 "구현부"로 이루어져있다.

    메서드의 선언부 - 메서드의 이름, 매개변수 선언, 반환타입
    메서드의 구현부 - 호출했을 때 수행될 문장들

    메서드의 호출 - 괄호()안에 지정해준 값들을 인수(argument) 또는 인자라고 함
    "인자의 개수와 순서"는 호출된 메서드에 선언된 매개변수와 일치해야함
*/
/*
    호출스택 (call stack)
    - 메서드의 작업에 필요한 메모리 공간 제공
    메서드 호출 -> 호출스택에 호출된 메서드를 위한 메모리가 할당 ->
    메서드가 작업을 수행하는 동안 지역변수들과 연산의 중간 결과 등을 저장하는데 사용
    => 메서드가 작업을 마치면 할당되었던 메모리 공간은 반환되어 비워짐
 */

/*
    메서드를 호출할 때 매개변수로 지정한 값을 메서드의 매겨변수에 복사해서 넘겨준다
    기본형 매개변수 : 변수의 값을 읽기만 할 수 있음    (기본형 값 복사)
    참조형 매개변수 : 변수의 값을 읽고 변경할 수 있음   (인스턴스 주소 복사)

 */
public class Ex6_6 {

    public static void main(String[] args) {

        System.out.println("기본형 매개변수");
        Data d = new Data();
        d.x = 10;
        System.out.println("d.x = " + d.x);

        change(d.x);
        System.out.println("After change, d.x = " + d.x);

        System.out.println("참조형 매개변수");
        Data d2 = new Data();
        d2.x = 10;
        System.out.println("d2.x = " + d2.x);
        change2(d2);
        System.out.println("After change, d2.x = " + d2.x);

        System.out.println("반환타입이 참조형");    // 반환하는 값의 타입이 참조형
        Data d3 = new Data();
        d3.x = 10;
        Data d4 = copy(d3);
        System.out.println("d3.x = " + d3.x);
        System.out.println("d4.x = " + d4.x);
    }

    static void change(int x) {  // 기본형 매개변수
        // change(d.x) 메서드가 호출되면서 d.x가 cahnge 메서드의 매개변수 x에 복사된다.
        // change 메서드에서 x의 값 1000으로 변경
        // change 메서드가 종료되면서 매개변수 x는 스택에서 제거됨
        // => d.x의 값이 변경된 것이 아니라 change 메서드의 매개변수 x의 값이 변경된 것!!!

        x = 1000;
        System.out.println("change x = " + x);
    }

    static void change2(Data d) {   // 참조형 매개변수
        // 값이 저장된 주소를 change2 메서드에 넘겨줌

        // change2 메서드가 호출되면서 참조변수 d의 값(주소)이 매개변수 d에 복사됨
        // => 이제 매개변수 d에 저장된 주소값으로 x에 접근 가능!
        // change2 메서드에서 매개변수 d로 x의 값을 1000으로 변경
        // change2 메서드가 종료되면서 매개변수 d는 스택에서 제거됨

        d.x = 1000;
        System.out.println("change x = " + d.x);
    }

    static Data copy(Data d) {
        Data tmp = new Data();  // 새로운 객체 tmp 생성
        tmp.x = d.x;    // d.x의 값을 tmp.x에 복사
        return tmp; // 복사한 객체의 주소를 반환
    }

}

class Data {
    int x;
}