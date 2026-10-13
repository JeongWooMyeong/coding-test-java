package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 평범한배낭7 {

    static int N,K;
    static int[] W;
    static int[] V;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[K+2];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<W.length;i++){
            for(int j=K;j>=W[i];j--){
                dp[j] = Math.max(dp[j], dp[j-W[i]] + V[i]);
            }
        }

        System.out.println(dp[K]);

    }

}
