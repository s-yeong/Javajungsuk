package org.chapter11.ex;

/*
    스택 활용 예
    - 수식계산, 수식괄호검사, 워드프로레서의 undo/redo, 웹브라우저의 뒤로/앞으로
    
    큐의 활용 예
    - 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
 */

import java.util.EmptyStackException;
import java.util.Stack;

class Ex11_3_Stack {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage:java Ex11_3_Stack \"EXPRESSON\"");
            System.out.println("Example:java Ex11_3_Stack \"((2+3)*1)+3");
            System.exit(0);
        }

        Stack st = new Stack();
        String expression = args[0];

        System.out.println("expression = " + expression);

        try{
            for(int i=0;i<expression.length(); i++) {
                char ch = expression.charAt(i);

                if(ch == '(') {
                    st.push(ch + "");
                } else if (ch == ')') {
                  st.pop();
                }
            }
            if (st.isEmpty()) {
                System.out.println("괄호 일치");
            } else {
                System.out.println("괄호 일치X");
            }
        } catch (EmptyStackException e) {   // st.pop 했을 때 빈 경우 예외 발생
            System.out.println("괄호 일치X");
        }

    }
}
