package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 평범한배낭3 {
    static int N, K;
    static int[] W, V;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            W[i] = w;
            int v = Integer.parseInt(st.nextToken());
            V[i] = v;
        }

        for(int i=1;i<=N;i++){
            for(int w=0;w<=K;w++){
                dp[i][w] = dp[i-1][w];
                if(w - W[i] >= 0){
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w-W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);


    }
}
