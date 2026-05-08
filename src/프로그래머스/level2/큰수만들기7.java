package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기7 {

    public static String solution(String number, int k){

        char[] c = number.toCharArray();
        //Deque<Character> deque = new LinkedList<>();
        Deque<Character> deque = new ArrayDeque<>();

        for(int i=0;i<c.length;i++){
            while(!deque.isEmpty() && deque.peekLast() < c[i] && k > 0){
                deque.pollLast();
                k--;
            }
            deque.add(c[i]);
        }

        while(k > 0){
            deque.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception{
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));
    }
}
