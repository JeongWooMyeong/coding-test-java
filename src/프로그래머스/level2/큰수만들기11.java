package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기11 {

    public static String solution(String number, int k){
        Deque<Character> dq = new ArrayDeque<>();
        char[] c = number.toCharArray();

        for(int i=0;i<c.length;i++){
            while(!dq.isEmpty() && dq.peekLast() < c[i] && k > 0){
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

        for(Character aa : dq){
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
