package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외판원순회16 {

    static int N;
    static int[][] dp;
    static int[][] W;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][(1<<N)];
        W = new int[N][N];

        for(int[] d1 : dp){
            Arrays.fill(d1, -1);
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,1));
    }

    static int dfs(int cur, int visited){
        if(visited == (1<<N) - 1){
            if(W[cur][0] == 0){
                W[cur][0] = Integer.MAX_VALUE;
            }

            return W[cur][0];
        }

        if(dp[cur][visited] != -1) return dp[cur][visited];

        int answer = Integer.MAX_VALUE;

        for(int next=0;next<N;next++){
            if(W[cur][next] == 0) continue;
            if((visited & (1<<next)) != 0) continue;

            int newvisited = visited | (1<<next);

            answer = Math.min(answer, W[cur][next] + dfs(next,newvisited));
        }

        return dp[cur][visited] = answer;
    }

}
