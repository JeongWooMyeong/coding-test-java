package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 멀리뛰기 {
    public static long solution(int n){
        long answer = 0;
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        if(n >= 2) dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }


        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        System.out.println(solution(n));
    }

}
