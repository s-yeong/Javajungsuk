package org.chapter7.exercise;

/**
 * 매개변수가 있는 메서드는 반드시 작업 전 유효성 검사를 해야한다
 */

// 섯다카드 20장을 포함하는 SutdaDeck 클래스
// 1부터 10까지 숫자가 적힌 카드가 한 쌍,
// 숫자가 1,3,8인 경우에는 둘 중의 한 장은 광(isKwang 값 true)
class SutdaDeck {

    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];
    // 이 배열을 생성했다고해서 SutdaCard 인스턴스가 생성된 것은 아님(저장하기 위한 공간을 생성)

    SutdaDeck() {
        for(int i=0; i<cards.length; i++) {

            int num = i%10 + 1;
            boolean isKwang = (i < 9) && (num==1 || num==3 || num==8);
            // i=0,1,2,3,4, ... i % 10 = 0,1,2,3,4 ...
            // i=10,11,12,13,14 ... i % 10 = 0,1,2,3,4 ...

            cards[i] = new SutdaCard(num, isKwang);
        }
    }

    void shuffle() {

        for(int i=0; i<cards.length; i++) {
            int j = (int) (Math.random() * cards.length);

            /*int tmp = cards[i].num;
            cards[i].num = cards[j].num;
            cards[j].num = tmp;

            if (cards[i].isKwang == true && cards[j].isKwang == true) {
            } else if (cards[i].isKwang == true && cards[j].isKwang == false) {
                cards[i].isKwang = false;
                cards[j].isKwang = true;
            } else if (cards[i].isKwang == false && cards[j].isKwang == true) {
                cards[i].isKwang = true;
                cards[j].isKwang = false;
            }*/

            // ----> num만 바꿀 필요가 없다!!!
            // ***** cards 하나가 ShutdaCard 객체 하나기 때문에 그것만 섞어주면 된다! *****
            SutdaCard tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;


        }
    }

    SutdaCard pick(int index) {
        // 유효성 검사!!!
        if(index < 0 || index > CARD_NUM)
            return null;
        return cards[index];
    }

    SutdaCard pick() {
        // pick(int index)를 호출하는 방식!
        int index = (int)(Math.random()*cards.length);
        return pick(index);
    }



}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1,true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    
    public String toString() {  // Object 클래스의 toString() 오버라이딩
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_2 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for(int i=0; i<deck.cards.length; i++) {
            System.out.print(((i==0)? "":",") + deck.cards[i]);
        }

        System.out.println();
        System.out.println(deck.pick(0));

    }


}
