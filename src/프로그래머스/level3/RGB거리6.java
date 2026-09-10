package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class RGB거리6 {

    static int N;
    static int[][] cost;
    static int[][] dp;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        dp = new int[N][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i=1;i<N;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            answer = Math.min(answer, dp[N-1][i]);
        }

        System.out.println(answer);
    }

}
