package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기17 {

    static char[] arr;
    static Deque<Character> dq;
    static StringBuilder sb;

    public static String solution(String number, int k){
        dq = new ArrayDeque<>();
        sb = new StringBuilder();

        arr = new char[number.length()];

        for(int i=0;i<number.length();i++){
            arr[i] = number.charAt(i);
        }

        for(int i=0;i<number.length();i++){
            while(!dq.isEmpty() && dq.peekLast() < arr[i] && k > 0){
                k--;
                dq.pollLast();
            }

            dq.addLast(arr[i]);
        }


        while(k>0){
            dq.pollLast();
            k--;
        }

        for(char c : dq){
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        String number = "1924";
        int k = 2;

        System.out.println(solution(number, k));
    }

}
