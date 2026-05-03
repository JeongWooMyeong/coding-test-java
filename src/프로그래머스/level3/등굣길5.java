package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등굣길5 {
    static int[][] maps;
    static int[][] dp;

    public static int solution(int m, int n, int[][] puddles){
        maps = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        int mod = 1000000007;
        //웅덩이 넣을때 좌표기준 yx로 넣어야함
        for(int[] p : puddles){
            int x = p[0];
            int y = p[1];

            maps[y][x] = -1;
        }

        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(maps[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                //시작점 제외
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
