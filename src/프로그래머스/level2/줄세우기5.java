package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 줄세우기5 {

    static int N;
    //static int[] arr;
    static int max;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        max = 0;
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
