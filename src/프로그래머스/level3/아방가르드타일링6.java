package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아방가르드타일링6 {

    static long[] dp;
    static int mod = 1000000007;

    public static int solution(int n){
        dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        if(n >= 2) dp[2] = 3;
        if(n >= 3) dp[3] = 10;
        if(n >= 4) dp[4] = 23;
        if(n >= 5) dp[5] = 62;

        for(int i=6;i<=n;i++){
            dp[i] = (dp[i-1] + 2 * dp[i-2] + 6 * dp[i-3] + dp[i-4] - dp[i-6]) % mod;
            if(dp[i] < 0) dp[i] += mod;
        }

        return (int)dp[n];
    }

    public static void main(String[] args) throws Exception{
        int n = 2;
        System.out.println(solution(n));
    }

}
