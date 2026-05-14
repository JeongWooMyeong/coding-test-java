package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
나는 괄호 종류가 3가지라
괄호 맞는거끼리 나눠서 구하면 되지 않을까 생각 했는데 틀렸다네..
 */

public class 괄호회전하기 {
    static Queue<Character> q;
    static List<Character> a;
    static List<Character> b;
    static List<Character> c;

    public static int solution(String s){
        int answer = 0;
        q = new LinkedList<>();

        for(int i=0;i<s.length();i++){
            q.offer(s.charAt(i));
        }


        for(int i=0;i<s.length();i++){
            a = new ArrayList<>();
            b = new ArrayList<>();
            c = new ArrayList<>();

            if(i == 0){
                a = toArr(q, '(',')');
                b = toArr(q, '{','}');
                c = toArr(q, '[',']');
                if(match(a) && match(b) && match(c)){
                    answer++;
                }
            }else{
                char cs = q.poll();
                q.offer(cs);
                a = toArr(q, '(',')');
                b = toArr(q, '{','}');
                c = toArr(q, '[', ']');
                if(match(a) && match(b) && match(c)){
                    answer++;
                }

            }
        }




        return answer;
    }

    static boolean match(List<Character> q){
        int count = 0;
        for(char c : q){
            if(c == '}' || c == ']' || c == ')'){
                count -= 1;
            }else{
                count += 1;
            }

            if(count == -1) return false;

        }

        return true;
    }

    static List<Character> toArr(Queue<Character> q, char prefix, char postfix){
        List<Character> list = new ArrayList<>();
        for(char c : q){
            if(c == prefix || c == postfix){
                list.add(c);
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        String s = "[](){}";
        System.out.println(solution(s));
    }

}
