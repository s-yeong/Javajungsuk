package org.chapter11.ex;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Ex11_4_Queue {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;  // Queue에 최대 5개까지만 저장

    public static void save(String input) {
        // queue에 저장
        if(!"".equals(input)) {     // if(input != null && !input.equal(""))
            // Queue에 객체를 저장, 성공하면 true, 실패하면 false
            q.offer(input);
        }
        
        // queue의 최대 크기를 넘으면 제일 처음 입력된 것 삭제
        if(q.size() > MAX_SIZE) {   //size()는 Collection 인터페이스에서 정의
            q.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말 볼 수 있습니다.");


        while(true) {
            System.out.print(">>");
            
            try {
                // 화면으로부터 라인단위로 입력받음
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim(); // trim() => 왼쪽, 오른쪽 공백 다 제거

                if("".equals(input)) continue;

                if(input.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if(input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말");
                    System.out.println(" q 또는 Q - 프로그램 종료");
                    System.out.println(" history - 최근에 입력한 명령어를"
                    + MAX_SIZE + "개 보여줍니다.");
                } else if(input.equalsIgnoreCase("history")) {

                    save(input);

                    // LinkedList의 내용 보여준다
                    LinkedList list = (LinkedList) q;

                    // list.size() 메소드를 계속 호출할게 아니라, final int SIZE = list.size();로 지정해준다
                    final int SIZE = list.size();
                    for(int i=0; i<SIZE; i++) {
                        System.out.println((i+1) + "." + list.get(i));
                    }
                } else {
                    save(input);
                    System.out.println(input);
                }
            } catch (Exception e) {
                System.out.println("입력오류");
            }
        }
    }
}
