package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
탑다운 방식 (재귀 + 메모이제이션)
 */

public class 등굣길3 {
    static int[][] dp;
    static boolean[][] puddle;

    public static int solution(int m, int n, int[][] puddles){
        dp = new int[n+1][m+1];
        puddle = new boolean[n+1][m+1];

        for(int[] p : puddles){
            puddle[p[1]][p[0]] = true;
        }
        //방문처리 -1 초기화
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }

        return dfs(n, m);

    }

    static int dfs(int i, int j){
        int mod = 1000000007;
        //범위 넘어갔을때
        if(i < 1 || j < 1) return 0;
        //웅덩이 일때
        if(puddle[i][j]) return 0;
        //자기 자신일때
        if(i == 1 && j == 1) return 1;
        //방문한적 있을때
        if(dp[i][j] != -1) return dp[i][j];
        //위 아래 처리
        dp[i][j] = (dfs(i-1, j) + dfs(i, j-1)) % mod;

        return dp[i][j];

    }

    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));

    }
}
