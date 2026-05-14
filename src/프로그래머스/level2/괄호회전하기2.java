package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 괄호회전하기2 {
    static Queue<Character> q;
    static Stack<Character> stack;

    public static int solution(String s){
        //큐로 일단 String s 다 담음.
        //회전 이동하면서 isValid 확인 (stack)
        q = new LinkedList<>();
        int answer = 0;

        for(int i=0;i<s.length();i++){
            q.offer(s.charAt(i));
        }

        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();

            for(char c : q){
                sb.append(c);
            }

            if(match(sb.toString())) answer++;

            q.offer(q.poll());

        }

        return answer;
    }

    static boolean match(String s){
        char[] c = s.toCharArray();
        stack = new Stack<>();

        for(char chr : c){
            if(chr == '{' || chr == '(' || chr == '['){
                stack.push(chr);
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if (chr == ')' && top != '(') return false;
                if (chr == '}' && top != '{') return false;
                if (chr == ']' && top != '[') return false;

            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) throws Exception{
        String s = "[](){}";
        System.out.println(solution(s));
    }

}
