package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파도반수열 {
    static int T, N;
    static long[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4;i<=100;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb.toString());

    }

}
