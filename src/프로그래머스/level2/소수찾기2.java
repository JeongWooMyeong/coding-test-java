package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기2 {
    static boolean[] visited;
    static int answer;
    static Set<Integer> set;

    public static int solution(String numbers){
        //int answer = 0;
        int n = numbers.length();
        visited = new boolean[n];
        set = new HashSet<>();
        answer = 0;

        dfs(0, new StringBuilder(), numbers.toCharArray());


        return answer;
    }

    static void dfs(int idx, StringBuilder sb, char[] c){
        if(sb.length() > 0){
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num) && !set.contains(num)){
                set.add(num);
                answer++;
            }

            //return;
        }

        for(int i=0;i<c.length;i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(c[i]);
                dfs(idx+1, sb, c);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);

            }
        }



    }

    static boolean isPrime(int num){
        if(num < 2) return false;
        //if(num == 2) return true;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "17";
        System.out.println(solution(numbers));
    }

}
