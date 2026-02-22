package 알고리즘정리2;

import java.util.*;
/*
괄호검사
 */
public class StackExample2 {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("()()"));
        System.out.println(isValid("(())"));
        System.out.println(isValid("(()"));
    }
}
