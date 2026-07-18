package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드게임10 {

    static int T;
    static int N;
    static int[] cards;
    static int[] prefix;
    static int[][] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            cards = new int[N+1];
            dp = new int[N+1][N+1];
            prefix = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                cards[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=N;i++){
                prefix[i] = prefix[i-1] + cards[i];
            }

            for(int len=1;len<=N;len++){
                for(int l=1;l+len-1<=N;l++){
                    int r = l + len -1;

                    if(l == r) dp[l][r] = cards[l];
                    else{
                        int sum = prefix[r] - prefix[l-1];
                        dp[l][r] = Math.max(cards[l] + sum - cards[l] - dp[l+1][r], cards[r] + sum - cards[r] - dp[l][r-1]);
                    }

                }
            }

            sb.append(dp[1][N]).append("\n");

        }

        System.out.println(sb.toString());
    }

}
