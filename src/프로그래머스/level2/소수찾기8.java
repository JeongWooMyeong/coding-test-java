package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기8 {

    static char[] arr;
    static Set<Integer> set;
    static boolean[] visited;

    public static int solution(String numbers){
        arr = numbers.toCharArray();
        set = new HashSet<>();
        visited = new boolean[arr.length];

        dfs("");

        return set.size();
    }

    static void dfs(String path){

        if(!"".equals(path) && isPrime(path)){
            set.add(Integer.parseInt(path));
            //return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(path + arr[i]);
                visited[i] = false;
            }
        }

    }

    static boolean isPrime(String numbers){
        int num = Integer.parseInt(numbers);

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
