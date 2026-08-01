package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class RGB거리3 {

    static int N;
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];
        cost = new int[N+1][3];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            cost[i][0] = red;
            cost[i][1] = green;
            cost[i][2] = blue;
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        for(int i=2;i<=N;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        int answer = Integer.MAX_VALUE;

        answer = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(answer);



    }

}
