package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기16 {

    static Stack<Character> stack;
    static char[] arr;

    public static String solution(String number, int k){
        stack = new Stack<>();
        arr = new char[number.length()];

        for(int i=0;i<number.length();i++){
            arr[i] = number.charAt(i);
        }

        for(int i=0;i<arr.length;i++){

            while(!stack.isEmpty() && stack.peek() < arr[i] && k > 0){
                stack.pop();
                k--;
            }

            stack.push(arr[i]);

        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number,k));
    }

}
