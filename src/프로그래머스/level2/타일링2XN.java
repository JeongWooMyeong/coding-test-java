package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 타일링2XN {
    static int[] dp;    //길이 n인걸 직사각형으로 채울 수 있는 경우의 수

    public static int solution(int n){
        int mod = 1000000007;

        if(n == 1)  return 1;
        if(n == 2)  return 2;

        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }


        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        System.out.println(solution(n));
    }

}
