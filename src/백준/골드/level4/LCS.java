package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
LCS (Longest Common Subsequence)
두 문자열에서 가장 긴 공통 부분수열
부분 수열 : 문자여이나 수열에서 순서를 유지하면서 일부 원소 고ㅡ는거 (연속 아니여도 됌)

 */

public class LCS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        //dp[i][j] A의 i번째까지, B의 j번째까지 고려했을때 LCS 길이
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
