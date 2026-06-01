package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기6 {

    static boolean[] visited;
    static Set<Integer> set;
    static char[] arr;
    static int n;

    public static int solution(String numbers){
        n = numbers.length();
        arr = numbers.toCharArray();
        set = new HashSet<>();

        visited = new boolean[n];

        dfs(0, "", arr);


        return set.size();
    }

    static void dfs(int idx, String num, char[] c){
        if(!"".equals(num) && isPrime(num)){
            set.add(Integer.parseInt(num));
        }

        if(idx == c.length) return;

        for(int i=0;i<c.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(idx+1, num + c[i], c);
                visited[i] = false;
            }
        }

    }

    static boolean isPrime(String num){
        int number = Integer.parseInt(num);
        if(number < 2) return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "17";
        System.out.println(solution(numbers));
    }


}
