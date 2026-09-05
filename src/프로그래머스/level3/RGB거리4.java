package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class RGB거리4 {

    static int N;
    static int[][] house;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][3];
        house = new int[N+1][3];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for(int i=2;i<=N;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            answer = Math.min(answer, dp[N][i]);
        }

        System.out.println(answer);
    }

}
