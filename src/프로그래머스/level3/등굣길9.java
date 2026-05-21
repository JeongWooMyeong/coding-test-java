package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
0 index 버전
1 index로 맞추고 하는게 더 편리한듯
0index로 할때에는 i,j 를 다 구할 수 없어서
따로 나눠서 해줘야함..
 */

public class 등굣길9 {
    static int[][] board;
    static int[][] dp;

    public static int solution(int m, int n, int[][] puddles){
        board = new int[n][m];
        dp = new int[n][m];

        int mod = 1000000007;
        //웅덩이 표ㅅ기
        for(int[] p : puddles){
            int x = p[0];
            int y = p[1];

            board[y-1][x-1] = -1;
        }

        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j  == 0) continue;
                if(board[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }

                int up = (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;

                dp[i][j] = (up + left) % mod;

            }
        }

        return dp[n-1][m-1];

    }


    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));
    }

}
