package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
DP + 구간 누적합
 */

public class 카드게임3 {
    static int T,N;
    static int[][] dp;
    static int[] card;
    static int[] prefix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1][N+1];
            card = new int[N+1];
            prefix = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                card[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i-1] + card[i];
            }

            for(int len=1;len<=N;len++){
                for(int l=1;l+len-1<=N;l++){
                    int r = l+len-1;
                    if(l==r){
                        dp[l][r] = card[l];
                    }else{
                        int sum = prefix[r] - prefix[l-1];
                        dp[l][r] = Math.max(card[l] + sum - card[l] - dp[l+1][r], card[r] + sum - card[r] - dp[l][r-1]);
                    }

                }
            }

            sb.append(dp[1][N]).append("\n");

        }

        System.out.println(sb.toString());
    }

}
