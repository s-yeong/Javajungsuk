package org.chapter7.ex.interfaceEx;


public class Fighter implements Fightable {


    public void move(int x, int y) {

    }

    public void attack(Fightable f) {
        // attack 메서드의 매개변수로 Fighter 인스턴스를 넘겨줄 수 있다.
        // => attack(new Fighter())
    }
    
    // 메서드의 리턴타입으로 인터페이스를 지정하는 것도 가능
    Fightable method() {
        Fighter f = new Fighter();
        return f;   // Fightable 인터페이스를 구현한 Fighter 클래스의 인스턴스의 주소 반환
    }
    /**
     * 중요!
     * 리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미
     */
}
