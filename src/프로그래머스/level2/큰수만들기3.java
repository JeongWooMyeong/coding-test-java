package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기3 {
    public static String solution(String number, int k){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        char[] c = number.toCharArray();


        stack.push(c[0]);
        int count = 0;
        for(int i=1;i<c.length;i++){
            if(count == k) break;

            if(stack.peek() < c[i]){
                stack.pop();
                stack.push(c[i]);
                count++;
            }
        }

        while(stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }
}
