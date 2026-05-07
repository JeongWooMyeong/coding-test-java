package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기4 {
    static boolean[] visited;
    static Set<Integer> set;

    public static int solution(String numbers){
        char[] c= numbers.toCharArray();
        set = new HashSet<>();
        visited = new boolean[numbers.length()];

        dfs("", c);


        return set.size();


    }

    static void dfs(String str, char[] c){
        if(!"".equals(str) && isPrime(str)){
            set.add(Integer.parseInt(str));
        }

        for(int i=0;i<c.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(str + c[i], c);
                visited[i] = false;
            }
        }

    }

    static boolean isPrime(String str){
        int num = Integer.parseInt(str);
        if(num < 2) return false;
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
