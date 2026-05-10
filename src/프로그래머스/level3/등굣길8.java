package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등굣길8 {
    static int[][] map;
    static int[][] dp;

    public static int solution(int m, int n, int[][] puddles){
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        int mod = 1000000007;

        //개울 -1로 정의
        for(int[] p : puddles){
            int x = p[0];
            int y = p[1];
            //좌표니 반대로
            map[y][x] = -1;
        }

        //dp 점화식 세워서 m-1, n-1로 도달 할 수 있는 경우의 수
        dp[1][1] = 1;   //자기자신으로 돌아오는 경우 한가지 존재
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(map[i][j] == -1){
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
