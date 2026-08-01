package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등굣길14 {

    static int[][] board;
    static int[][] dp;
    static int mod = 1000000007;

    public static int solution(int m, int n, int[][] puddles){
        board = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int[] p : puddles){
            int x = p[0];
            int y = p[1];

            board[y][x] = 1;
        }

        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(board[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                if(i == 1 && j == 1) continue;

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
