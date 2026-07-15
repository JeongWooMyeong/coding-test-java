package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기14 {

    static char[] arr;
    static int n;
    static Deque<Character> dq;

    public static String solution(String number, int k){
        n = number.length();
        arr = new char[n];
        for(int i=0;i<n;i++){
            arr[i] = number.charAt(i);
        }

        dq = new ArrayDeque<>();
        //k--; //0 index;

        for(int i=0;i<n;i++){
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


        StringBuilder sb = new StringBuilder();
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
