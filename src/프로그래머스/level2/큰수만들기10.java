package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기10 {

    static Stack<Character> stack;

    public static String solution(String number, int k){
        char[] c = number.toCharArray();
        stack = new Stack<>();

        for(int i=0;i<c.length;i++){
            while(!stack.isEmpty() && stack.peek() < c[i] && k > 0){
                stack.pop();
                k--;
            }

            stack.push(c[i]);
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(Character aa : stack){
            sb.append(aa);
        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception{
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }

}
