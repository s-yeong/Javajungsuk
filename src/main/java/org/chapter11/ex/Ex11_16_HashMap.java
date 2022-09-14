package org.chapter11.ex;

import java.util.HashMap;
import java.util.Scanner;

/*
    Hashtable과 HashMap의 관계는 Vector와 ArrayList의 관계와 같아서 HashMap을 사용할 것을 권함
    
    HashMap
    Map을 구현 - key, value를 묶어서 하나의 데이터(entry)로 저장한다는 특징
    해싱(hashing)을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어난 성능을 보임

    public class HashMap extends AbstractMap implements Map, Cloenable, Serializable
    {
        transient Entry[] table;    // 배열 - 여기에 저장됨

        static class Entry implements Map.Entry {
            final Object key;
            Object value;

    - Entry라는 내부 클래스를 정의하고, 다시 Entry 타입의 배열을 선언하고 있음
    - key와 value는 별개의 값이 아닌 서로 관련된 값이기 때문에 각각의 배열로 선언하기 보다
    하나의 클래스로 정의해서 하나의 배열로 다루는 것이 데이터의 무결성적인 측면에서 더 바람직함
    - 키와 값을 Object 타입으로 저장한다 (Object, OBject) -> 어떠한 객체도 저장할 수 있음 but, 키는 주로 String을 대문자 또는 소문자로 통일함
    key : 컬랙션 내의 key 중에서 유일해야 함
    value : key와 달리 데이터의 중복을 허용함

 */

/*
    해싱
    ex) 환자정보관리 -> 저 많은 환자정보를 어떻게 관리하지? => 출생년도로 분류해서, 캐비넷에 저장하자!
    00년대, 10년대, 20년대
    ex) 환자번호좀 찾아주세요 주민번호는 10xxx -> 10xxx이면 2번 서랍에 있겠네!

    해시함수 => 어떤 key값을 넣으면 배열의 index를 알려줌 => 저장위치를 알려줌 (해시코드)
    key -> [ 해시함수 ]-> 해시코드
    해당 key가 저장된 곳을 쉽게 찾을 수 있음

    해싱 => 해쉬 함수를 이용해서 해시테이블에 데이터를 저장하고 읽어오는 것
    key 넣으면 어디에 저장위치(해시코드)를 줌 - 해시코드 : 배열의 index
    해시테이블 => 데이터를 저장하는 공간, 배열과 링크드 리스트가 조합된 형태(이차원 배열 형태)
    (배열의 장점 : 접근성) + (링크드 리스트 : 변경 유리)
    [ 배열 -> 링크드 리스트 ]

    해시 함수는 Object.hash()를 통해 작성하면 됨
    hashcode() 메소드 사용하는 것들 - Hashtable, HashMap, HashSet
    Object.hash()를 오버라이딩 해서 해쉬함수를 작성하면 됨

    해시테이블에 저장된 데이터를 가져오는 과정
    1) 키로 해시함수를 호출해서 해시코드를 읽는다
    2) 해시코드(해시함수의 반환값)에 대응하는 링크드리스트를 배열에서 찾음
    3) 링크드리스트에서 키와 일치하는 데이터를 찾음
    ** 해시함수는 같은 키에 대해 항상 같은 해시코드를 반환해야함
    ** 서로 다른 키일지라도 같은 값의 해시코드를 반환할 수 있음 (배열 찾는 것까지는 같음 - 같은 캐비넷이 있을 수 있음)

 */

/*
    데이터를 읽어오는 메서드
    - entry 가져오는 것 : Set entrySet()
    - key만 가져오는 것 : Set entrykey()
    - value만 가져오는 것 : Collection values()
 */
public class Ex11_16_HashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        // 지정된 키와 값을 HashMap에 저장
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");    // 이미 존재하는 키 추가가능 (기존 값 없어짐)

        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("id와 password 입력");
            System.out.print("id :");
            String id = s.nextLine().trim();

            System.out.print("password :");
            String password = s.nextLine().trim();
            System.out.println();

            // HashMap에 지정된 키가 포함되어있는지 알려줌
            if(!map.containsKey(id)) {
                System.out.println("입력하신 id 존재X, 다시 입력");
                continue;
            }

            // 지정된 key의 값을 반환 (못찾으면 null 반환)
            if(!(map.get(id)).equals(password)) {
                System.out.println("비밀번호 일치X");
            } else {
                System.out.println("비밀번호 일치");
                break;
            }

        }

    }
}
