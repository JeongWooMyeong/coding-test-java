package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등굣길4 {
    static int[][] dp;


    public static int solution(int m, int n, int[][] puddles){
        int answer = 0;
        dp = new int[n+1][m+1];
        int mod = 1000000007;
//        for(int i=1;i<=n;i++){
//            Arrays.fill(dp[i], -1);
//        }

        for(int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //웅덩이 만났을때 가는 방법은 0
                if(dp[i][j] == -1){
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

        System.out.println(solution(m, n, puddles));
    }

}
