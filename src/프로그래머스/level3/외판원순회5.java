package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외판원순회5 {

    static int N;
    static int[][] W;
    static int[][] dp;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        dp = new int[N][(1<<N)];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,1));

    }

    static int dfs(int cur, int visited){
        if(visited == (1<<N) - 1){
            if(W[cur][0] == 0){
                return INF;
            }

            return W[cur][0];
        }

        if(dp[cur][visited] != -1){
            return dp[cur][visited];
        }

        int answer = INF;

        for(int next=0;next<N;next++){
            if((visited & (1<<next)) != 0) continue;

            if(W[cur][next] == 0) continue;

            int newVisited = visited | (1<<next);

            answer = Math.min(answer, W[cur][next] + dfs(next, newVisited));

        }

        return dp[cur][visited] = answer;
    }

}
