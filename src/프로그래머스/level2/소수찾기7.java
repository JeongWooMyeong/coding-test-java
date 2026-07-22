package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기7 {

    static char[] arr;
    static boolean[] visited;
    static int n;
    static Set<Integer> set;

    public static int solution(String numbers){
        n = numbers.length();
        arr = numbers.toCharArray();
        set = new HashSet<>();

        visited = new boolean[n];
        dfs(0, "");

        return set.size();
    }

    static void dfs(int idx, String path){
        if(!"".equals(path) && isPrime(path)){
            set.add(Integer.parseInt(path));
        }

        if(idx == arr.length) return;

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(idx+1,path+arr[i]);
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
