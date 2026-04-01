package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 편집거리 {
    static String A,B;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        int N = A.length();
        int M = B.length();

        dp = new int[N+1][M+1];

        for(int i=0;i<=N;i++) dp[i][0] = i;
        for(int j=0;j<=M;j++) dp[0][j] = j;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1] + 1, Math.min(dp[i-1][j]+1, dp[i-1][j-1]+1));
                }
            }
        }

        System.out.println(dp[N][M]);

    }

}
