package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class RGB거리8 {

    static int N;
    static int[][] house;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        house = new int[N][3];
        dp = new int[N][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            house[i][0] = red;
            house[i][1] = green;
            house[i][2] = blue;
        }

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        for(int i=1;i<N;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            answer = Math.min(answer, dp[N-1][i]);
        }

        System.out.println(answer);
    }

}
