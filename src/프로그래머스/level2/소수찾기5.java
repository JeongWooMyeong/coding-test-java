package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기5 {
    static Set<Integer> result;
    static boolean[] visited;
    static char[] arr;
    static int n;

    public static int solution(String numbers){
        arr = numbers.toCharArray();
        n = arr.length;
        visited = new boolean[n];
        result = new HashSet<>();


        dfs("", arr);

        return result.size();

    }

    static void dfs(String str, char[] arr){

        if(!"".equals(str)){
            if(isPrime(str)){
                result.add(Integer.parseInt(str));
            }
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(str + arr[i], arr);
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
