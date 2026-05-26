package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 타일링3XN {
    static long[] dp;

    public static int solution(int n){
        int answer = 0;
        dp = new long[n+1];
        int mod = 1000000007;

        if(n % 2 != 0) return 0;

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for(int i=4;i<=n;i++){
            dp[i] = (4 * dp[i - 2] % mod - dp[i - 4] + mod) % mod;
        }


        return (int)dp[n];


    }

    public static void main(String[] args) throws Exception{
        int n =4;
        System.out.println(solution(n));
    }

}
