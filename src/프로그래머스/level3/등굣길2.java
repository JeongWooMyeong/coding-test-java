package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등굣길2 {
    static int[][] dp;
    static boolean[][] puddle;

    public static int solution(int m, int n, int[][] puddles){
        dp = new int[n+1][m+1];
        puddle = new boolean[n+1][m+1];
        int mod = 1000000007;

        for(int[] p : puddles){
            puddle[p[1]][p[0]] = true;
        }
        //자기 자신 가는길
        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i == 1 && j == 1) continue;
                if(puddle[i][j]) continue;

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));

    }

}
