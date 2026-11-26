package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아방가르드타일링11 {

    public static int solution(int n){
        final int MOD = 1000000007;
        long[] dp = new long[n+1];
        long[] g = new long[n+1]; //길이 4 이상 고유 모양 누적합

        dp[0] = 1;
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1];
            if(i >= 2) dp[i] += 2 * dp[i-2];
            if(i >= 3) dp[i] += 5 * dp[i-3];

            if(i >= 4) g[i] += 2 * dp[i-4];
            if(i >= 5) g[i] += 2 * dp[i-5];
            if(i >= 6) g[i] += 4 * dp[i-6];
            if(i >= 3) g[i] += g[i-3];
            g[i] %= MOD;

            dp[i] = (dp[i] + g[i]) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        System.out.println(solution(n));
    }

}
