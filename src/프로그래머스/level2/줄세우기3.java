package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 줄세우기3 {

    static int N;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        max = Integer.MIN_VALUE;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            int idx = Integer.parseInt(st.nextToken());
            dp[idx] = dp[idx-1] + 1;
            max = Math.max(max, dp[idx]);
        }

        System.out.println(N - max);
    }

}
