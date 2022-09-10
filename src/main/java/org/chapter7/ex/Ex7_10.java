package org.chapter7.ex;

/*
    추상 클래스
    미완성 설계도, 인스턴스 생성 불가
    미완성 메서드(추상 메서드)를 포함하고 있는 클래스
    => 상속을 통해서 자손클래스에 의해서만 완성될 수 있음
    => 새로운 클래스를 작성하는데 있어서 바탕이 되는 조상 클래스로서 중요한 의미를 가짐

    *** "추상화" : 기존의 클래스의 공통부분을 뽑아내서 조상 클래스를 만드는 것
 */

/*
    추상 메서드
    선언부만 작성하고 구현부는 작성하지 않은 채 남겨둔 것(설계만 해놓고 실제 수행될 내용 작성X)
    why? 메서드 내용이 상속받는 클래스에 따라 달라질 수 있기 때문에

    => 추상클래스를 상속받는 자손 클래스는 오버라이딩을 통해 조상인 추상클래스의 추상메서드를 "모두" 구현 해주어야함
    하나라도 구현하지 않은게 있으면 자손클래스도 추상클래스로 지정해야함
 */
public class Ex7_10 {
    public static void main(String[] args) {
        Unit[] group = {new Marine(), new Tank(), new Dropship()};
        for(int i=0; i< group.length; i++) {
            group[i].move(100, 200);
            // 메서드는 참조변수의 타입에 관계없이 실제 인스턴스에 구현된 것이 호출된다.
        }
    }
}


abstract class Unit {
    // 각 클래스의 공통부분을 뽑아내서 정의
    // 다른 유닛을 위한 클래스를 작성하는데 재활용될 수 있음
    int x, y;

    abstract void move(int x, int y);

    void stop() { // 현재 위치 정지
    }
}

    class Marine extends Unit { // 보병
        void move(int x, int y) {
            System.out.println("Marin[x=" + x + ", y=" + y + "]");
        }

        void stimPack() { // 스팀팩 사용
        }
    }

    class Tank extends Unit {
        void move(int x, int y) {
            System.out.println("Tank[x=" + x + ", y=" + y + "]");
        }
        void changeMode() { // 공격모드를 변환
        }
    }

    class Dropship extends Unit {
        void move(int x, int y) {
            System.out.println("Dropship[x=" + x + ", y=" + y + "]");
        }
        void load() {   // 선택한 대상 태우기
        }
        void unload() { // 선택한 대상 내리기
        }
    }

