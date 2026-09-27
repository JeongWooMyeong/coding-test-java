package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기10 {

    static boolean[] visited;
    static char[] arr;
    static Set<Integer> result;

    public static int solution(String numbers){
        arr = numbers.toCharArray();

        visited = new boolean[arr.length];
        result = new HashSet<>();

        dfs("");

        return result.size();
    }

    static void dfs(String path){
        if(!"".equals(path)){
            //System.out.println(path);
            if(isPrime(path)){
                result.add(Integer.parseInt(path));
            }
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(path + arr[i]);
                visited[i] = false;
            }
        }

    }

    static boolean isPrime(String number){
        int num = Integer.parseInt(number);

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
