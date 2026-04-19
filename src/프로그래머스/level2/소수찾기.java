package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기 {
    static Set<Integer> set = new HashSet<>();

    public static int solution(String numbers){
        int answer = 0;
        char[] arr = new char[numbers.length()];
        boolean[] visited = new boolean[arr.length];

        for(int i=0;i<arr.length;i++){
            arr[i] = numbers.charAt(i);
        }

        dfs("", arr, visited);

        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }


        return answer;
    }

    static void dfs(String current, char[] arr, boolean[] visited){
       if(!current.equals("")){
           set.add(Integer.parseInt(current));
       }

       for(int i=0;i<arr.length;i++){
           if(!visited[i]){
               visited[i] = true;
               dfs(current + arr[i], arr, visited);
               visited[i] = false;
           }
       }


    }

    static boolean isPrime(int n){
        if(n <= 1) return false;    //1 이하는 소수 아님
        if(n == 2) return true;
        if(n%2 == 0) return false;  //짝수는 소수 아님

        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i == 0) return false;  //나누어 떨어지면 합성수
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "17";

        System.out.println(solution(numbers));
    }

}
