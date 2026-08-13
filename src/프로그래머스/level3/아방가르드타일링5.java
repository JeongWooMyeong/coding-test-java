package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아방가르드타일링5 {

    static long[] dp;
    static int mod = 1000000007;

    public static int solution(int n){
        dp = new long[n+1];

        dp[0] = 1;
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 3;
        if(n >= 3) dp[3] = 10;
        if(n >= 4) dp[4] = 23;
        if(n >= 5) dp[5] = 62;

        for(int i=6;i<=n;i++){
            //나머지 -> 음수 보정이 안전
            dp[i] = (dp[i-1] + 2 * dp[i-2] + 6 * dp[i-3] + dp[i-4] - dp[i-6]) % mod;
            if(dp[i] < 0) dp[i] += mod;
            //dp[i] %= mod;
        }

        return (int)dp[n];
    }

    public static void main(String[] args) throws Exception{
        int n = 2;
        System.out.println(solution(n));
    }

}
