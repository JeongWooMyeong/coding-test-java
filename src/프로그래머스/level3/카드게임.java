package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드게임 {
    static int T;
    static int N;
    static int[] card;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            card = new int[N];
            dp = new int[N][N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<N;i++){
                Arrays.fill(dp[i], -1);
            }


            sb.append(dfs(0, N - 1, true)).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int dfs(int left, int right, boolean flag){
        if(left > right) return 0;
        if(dp[left][right] != -1) return dp[left][right];

        if(flag){
            return dp[left][right] = Math.max(card[left] + dfs(left+1, right, false), card[right] + dfs(left, right-1, false));
        }else{
            return dp[left][right] = Math.min(dfs(left+1,right,true), dfs(left,right-1,true));
        }

    }



}
