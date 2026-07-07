package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파도반수열3 {

    static int T, N;
    static long[] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());

            dp = new long[N+1];
            dp[1] = 1;
            if(N >= 2) dp[2] = 1;
            if(N >= 3) dp[3] = 1;

            for(int i=4;i<=N;i++){
                dp[i] = dp[i-2] + dp[i-3];
            }

            sb.append(dp[N]).append("\n");

        }

        System.out.println(sb.toString());

    }

}
