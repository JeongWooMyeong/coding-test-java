package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기5 {

    public static String solution(String number, int k){
        char[] c = number.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<c.length;i++){
            while(!stack.isEmpty() && stack.peek() < c[i] && k > 0){
                stack.pop();
                k--;
            }

            stack.push(c[i]);

        }

        if(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) throws Exception{
        String number ="1231234";
        int k = 3;

        System.out.println(solution(number,k));
    }

}
