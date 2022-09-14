package org.chapter11.ex;

/*
    스택(Stack)   - 배열과 달리 위치는 0이 아닌 "1"부터 시작 (맨 위의 요소가 1)
    마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO 구조 (Last In First Out)
    - 순차적으로 데이터를 추가하고 삭제하기에 "ArrayList와 같은 배열기반"의 컬렉션 클래스 적합

    큐(Queue)
    처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO 구조 (First in First out)
    - 데이터를 꺼낼 때 항상 첫 번째 저장된 데이터를 삭제하므로, 데이터 추가/삭제가 쉬운 "LinkedList"로 구현
    (ArrayList와 같은 배열기반의 컬렉션 클래스를 사용한다면
     데이터를 꺼낼 때마다 빈 공간을 채우기 위해 데이터의 복사가 발생하므로 비효율적!)
    
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Ex11_2_StackAndQueue {
    public static void main(String[] args) {
        
        Stack st = new Stack();
        Queue q = new LinkedList(); // Queue 인터페이스의 구현체인 LinkedList를 사용

        // Stack에 객체(item)를 저장
        st.push("0");
        st.push("1");
        st.push("2");

        // Queue에 객체를 저장, 성공하면 true, 실패하면 false 반환
        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("= Stack =");
        while(!st.empty()) {
            // 스택의 맨 위에 저장된 객체를 꺼낸다 - 빈 경우 EmptyStackException
            System.out.println(st.pop());   // 꺼내서 출력
        }

        System.out.println("= Queue =");
        while(!q.isEmpty()) {
            // 큐에서 객체를 꺼내서 반환 - 빈 경우 null
            System.out.println(q.poll());   // 꺼내서 출력
        }
    }
}
