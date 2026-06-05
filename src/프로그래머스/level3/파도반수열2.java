package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파도반수열2 {

    static long[] dp;
    static int T, N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

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
