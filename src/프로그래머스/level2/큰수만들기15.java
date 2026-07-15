package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기15 {

    static Stack<Character> stack;
    static char[] arr;
    static int n;

    public static String solution(String number, int k){
         n = number.length();
         arr = new char[n];

         for(int i=0;i<n;i++){
             arr[i] = number.charAt(i);
         }

         stack = new Stack<>();

         for(int i=0;i<n;i++){
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
