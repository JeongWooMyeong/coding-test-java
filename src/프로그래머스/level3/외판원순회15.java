package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외판원순회15 {

    static int N;
    static int[][] W;
    static int[][] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N+1][(1<<N)];

        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(1, 1));

    }

    static int dfs(int cur, int visited){
        if(visited == (1<<N) - 1){
            if(W[cur][1] == 0) return Integer.MAX_VALUE;

            return W[cur][1];
        }

        if(dp[cur][visited] != -1){
            return dp[cur][visited];
        }

        int answer = Integer.MAX_VALUE;

        for(int next=1;next<=N;next++){
            if(W[cur][next] == 0) continue;

            if((visited & (1<<next-1)) != 0) continue;

            int newVisited = visited | (1<<next-1);

            answer = Math.min(answer, dfs(next, newVisited) + W[cur][next]);

        }

        return dp[cur][visited] = answer;

    }

}
