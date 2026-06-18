package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 멀리뛰기3 {

    static long[] dp;
    static int mod = 1234567;

    public static long solution(int n){
        dp = new long[n+1];

        dp[0] = 1;  //아무것도 안하고 도착하는 경우
        dp[1] = 1;
        if(n >=2) dp[2] = 2;

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
