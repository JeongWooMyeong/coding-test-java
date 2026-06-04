package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아방가르드타일링3 {

    static long[] dp;

    public static int solution(int n){
        dp = new long[n+1];
        int mod = 1000000007;
        //아무것도 안놓은 경우 -> 경우의 수 포함
        dp[0] = 1;
        //구한 점화식으로 구할 수 있네..
        if(n >=1) dp[1] = 1;
        if(n >=2) dp[2] = 3;
        if(n >=3) dp[3] = 10;
        if(n >=4) dp[4] = 23;
        if(n >=5) dp[5] = 62;

        for(int i=6;i<=n;i++){
            dp[i] = (dp[i-1] + (2 * dp[i-2]) + (6 * dp[i-3]) + dp[i-4] - dp[i-6]) % mod;
            dp[i] %= mod;
            //이해가...?? ahem
            if(dp[i] < 0) dp[i] += mod;
        }


        return (int)dp[n];

    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        System.out.println(solution(n));
    }

}
