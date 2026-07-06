package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기13 {

    static Deque<Character> dq;

    public static String solution(String number, int k){
        dq = new ArrayDeque<>();

        char[] c = number.toCharArray();

        for(int i=0;i<c.length;i++){
            while(!dq.isEmpty() && k > 0 && c[i] > dq.peekLast()){
                dq.pollLast();
                k--;
            }

            dq.addLast(c[i]);

        }

        while(k > 0){
            dq.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(char ca : dq){
            sb.append(ca);
        }


        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        String number = "1924";
        int k = 2;

        System.out.println(solution(number, k));
    }

}
