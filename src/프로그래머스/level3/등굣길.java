package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등굣길 {
    static boolean[][] puddle;
    static int[][] dp;

    public static int solution(int m, int n, int[][] puddles){
        int answer = 0;
        int mod = 1000000007;

        dp = new int[n+1][m+1];
        puddle = new boolean[n+1][m+1];
        //좌표랑 배열은 반대개념 puddle[y][x] 가 맞음
        for(int[] p : puddles){
            puddle[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(puddle[i][j]){
                    dp[i][j] = 0;
                }else{
                    if(i > 1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % mod; //위에서 내려올때
                    if(j > 1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % mod; //왼쪽에서 오른쪽으로 올때
                }

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
