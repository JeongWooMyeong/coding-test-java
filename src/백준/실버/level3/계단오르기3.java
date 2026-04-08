package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 계단오르기3 {
    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        stairs = new int[N+1];
        dp = new int[301];

        for(int i=1;i<=N;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1]+stairs[2], stairs[1] + stairs[3]);

        for(int i=4;i<=N;i++){
            dp[i] = Math.max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2] + stairs[i]);
        }

        System.out.println(dp[N]);

    }



}
