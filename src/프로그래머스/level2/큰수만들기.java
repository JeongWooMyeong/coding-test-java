package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기 {
    public static String solution(String number, int k){
        String answer = "";
        char[] arr = new char[number.length()];
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<number.length();i++){
            char c = number.charAt(i);
            //arr[i] = number.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() < c){
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        answer = sb.toString();






        return answer;
    }

    public static void main(String[] args) throws Exception{
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }

}
