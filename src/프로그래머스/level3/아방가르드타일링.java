package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아방가르드타일링 {
    static int[] dp;

    public static int solution(int n ){
        dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        if(n >= 3) {
            dp[3] = 10;
        }

        int[] sum = {2,2,4};
        int sumlen = sum.length;
        int sums = 0;
        int mod = 1000000007;

        for(int i=4;i<=n;i++){
            sums += sum[(i-1)%3];
            dp[i] = (dp[i-1] + 2*dp[i-2] + 5*dp[i-3]) % mod;
            dp[i] += (sums) % mod;
        }

        return dp[n] % mod;
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        System.out.println(solution(n));
    }

}
