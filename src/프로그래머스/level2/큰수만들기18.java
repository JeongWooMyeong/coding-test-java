package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기18 {

    static Deque<Character> dq;
    static StringBuilder sb;
    static char[] arr;

    public static String solution(String number, int k){
        arr = new char[number.length()];

        for(int i=0;i<number.length();i++){
            arr[i] = number.charAt(i);
        }

        dq = new ArrayDeque<>();
        sb = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.peekLast() < arr[i] && k > 0){
                dq.pollLast();
                k--;
            }

            dq.addLast(arr[i]);
        }


        while(k > 0){
            dq.pollLast();
            k--;
        }

        for(char c : dq){
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
