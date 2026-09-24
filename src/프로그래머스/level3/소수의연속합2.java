package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 소수의연속합2 {

    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        for(int i=2;i<=N;i++){
            if(isPrime(i)){
                list.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int answer = 0;
        int sum = 0;

        while(true){
            if(sum >= N){
                if(sum == N) answer++;

                sum -= list.get(left++);
            }else{
                if(right == list.size()) break;

                sum += list.get(right++);

            }
        }

        System.out.println(answer);
    }

    static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }

        return true;
    }

}
