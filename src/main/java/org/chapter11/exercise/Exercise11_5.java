package org.chapter11.exercise;

import java.util.HashSet;
import java.util.Objects;

// SutdaCard 클래스를 HashSet에 저장하고 출력하는 예제
// 중복된 카드가 저장되지 않도록 하기

// HashSet의 add 메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별
// 하기위해 추가하려는 요소의 "equals()와 hashCode()를 호출"한다
// => equals()와 hashCode()를 목적에 맞게 오버라이딩 해야함!!!

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SutdaCard) {
            SutdaCard c = (SutdaCard) obj;
            return num == c.num && isKwang == c.isKwang;
        } else {
            return false;
        }
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }

    @Override
    public int hashCode() {
        // String 클래스의 hashCode() 호출
        return toString().hashCode();
    }
    
}

public class Exercise11_5 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);
        SutdaCard c3 = new SutdaCard(1, true);

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}

/*
    hashCode()의 기본 구현은 1. 클래스 이름 2. 메모리주소
    와 관련된 정수값으로 이루어져 있기 때문에,
    두 객체의 hashCode()값은 절대 같을 수 없다!!
    (서로 다른 두 객체가 같은 메모리 번지에 존재할 수 없기 때문에)

    대부분 경우 서로 다른 객체라도 클래스의 인스턴스 변수 값이 같으면, 같은 객체로 인식
    ex) num, isKwang이 같으면..
    하지만 해시코드도 판단하기 때문에,  두 객체의 해시코드(hashcode() 호출 결과)도 같아야 한다!

    HashSet의 경우 중복을 허용하지 않는다.
    eqauls()와 hashCode()를 판단하는 기준이 제대로 되어있지 않기 때문에, 중복을 허용하고 있다!
    => 두 메서드를 반드시 오버라이딩 시켜줘야한다! (오버라이딩 후 중복이 제거된 결과를 얻을 수 있다)

    hashCode() 오버라이딩 방법
    이미 다 구현되어 있기 때문에, 그냥 가져다 쓰기만 하면 된다.
    String 클래스의 hashCode()는 "객체의 주소"가 아닌 "문자열의 내용"을 기반으로 해시코드를 생성한다
    => 문자열의 내용이 같으면 항상 같은 값의 해시코드 반환
    => 인스턴스 변수들의 값을 결합한 문자열을 만들고, 그 문자열에 대해 hashCode()를 호출하는 방법
 */
