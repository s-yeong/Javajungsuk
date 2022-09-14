package org.chapter11.ex;

import java.util.HashSet;
import java.util.Objects;

public class Ex11_11_HashSet {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("abc");
        set.add("abc");
        set.add(new Person("David",10));
        set.add(new Person("David",10));

        System.out.println(set);
        // --- David:10이 두번 출력된다!!
        // ->  두 인스턴스를 같은 것으로 인식하게 하기 - equals, hashCode 오버라이딩
        // HashSet의 add 메서드는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별
        // 하기위해 추가하려는 요소의 equals()와 hashCode()를 호출한다
        // => hashCode()도 목적에 맞게 오버라이딩 해야함
    }
}

class Person {
    // name과 age를 멤버변수로 가짐
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + ":" + age;
    }

    // 오버라이딩
    public boolean equals(Object obj) {

        if(!(obj instanceof Person)) return false;  // 형변환 하기전에 항상 체크
        Person p = (Person)obj;
        // obj.name은 안된다 -> obj 라는 객체에는 name이 없음. 그렇기에 형변환
        return name.equals(p.name) && age==p.age;
    }

    // 오버라이딩
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
