package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 소수찾기3 {
    static boolean[] visited;
    static Set<Integer> prime;
    static int answer;

    public static int solution(String numbers){
        answer = 0;
        prime = new HashSet<>();
        visited = new boolean[numbers.length()];

        dfs("", numbers.toCharArray());


        return answer;
    }

    static void dfs(String current, char[] arr){
        if(!"".equals(current)){
            int num = Integer.parseInt(current);
            if(isPrime(num) && !prime.contains(num)){
                prime.add(num);
                answer++;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(current + arr[i], arr);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int num){
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
