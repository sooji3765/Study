# 중위표기식 후위표기식으로 변경

~~~java
package samsung;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class PostOrder {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int test_case = sc.nextInt();
        
        for(int i=0;i<test_case;i++) {
            String input = sc.next();
            System.out.println(inTopost(input));
        }

    }
    
    // 연산자 우선순위 결정
    private static int pre(char op) {
        
        switch (op) {
            case '*': case '/' : return 2;
            case '+': case '-' : return 1;
            case '(': case ')' : return 0;
        }
        
        return -1;
    }

    private static String inTopost(String input) throws EmptyStackException{
        
        char[] exp = input.trim().toCharArray();
        String result ="";
        Stack<Character> stack = new Stack<>();
    
        char ch, top_op;
        stack.push(exp[0]);
        for (int i = 1; i < exp.length; i++) {
            ch= exp[i];
            
            switch (ch) {
            case '+': case '-' : case '*' : case '/' :
                while(!stack.isEmpty()&&pre(ch)<=pre(stack.peek()))
                    result+=stack.pop();
                stack.push(ch);
                break;
            case '(' :
                stack.push(ch);
                break;
            case ')':
                top_op = stack.pop(); // 에러 발생
                System.out.println(top_op);
                while(top_op!='(') {
                    result+=top_op;
                    top_op= stack.pop();
                }
                
                break;
            default:
                result+=ch;
                break;
            }
            
            while(!stack.empty()) {
                result+=stack.pop();
            }
            
            
        }
        return result;
    }

}

~~~

