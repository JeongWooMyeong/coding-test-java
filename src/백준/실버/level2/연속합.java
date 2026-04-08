package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 연속합 {
    static int n;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        //i까지의 연속합
        dp[0] = num[0];


        for(int i=1;i<n;i++){
            dp[i] = Math.max(num[i], dp[i-1] + num[i]);
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }


}
