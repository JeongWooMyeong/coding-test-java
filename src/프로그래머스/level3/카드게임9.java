package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
근데 이걸 dp로 풀어야할지 어떻게 알 수 있을까??..
 */

public class 카드게임9 {

    static int T, N;
    static int[] card;
    static int[][] dp;
    static int[] prefix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            card = new int[N+1];
            prefix = new int[N+1];
            dp = new int[N+1][N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                card[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i-1] + card[i];
            }

            for(int len=1;len<=N;len++){
                for(int l=1;l+len-1<=N;l++){
                    int r = l + len - 1;
                    if(l == r) dp[l][r] = card[l];
                    else{
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
