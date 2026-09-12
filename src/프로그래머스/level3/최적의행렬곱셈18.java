package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최적의행렬곱셈18 {

    static int n;
    static long[][] dp;

    public static int solution(int[][] matrix_sizes){
        n = matrix_sizes.length;

        dp = new long[n+1][n+1];

        for(int i=1;i<=n;i++){
            dp[i][i] = 0;
        }

        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    long cost = dp[i][k] + dp[k+1][j] + matrix_sizes[i-1][0] * matrix_sizes[k-1][1] * matrix_sizes[j-1][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }

            }
        }

        return (int)dp[1][n];

    }

    public static void main(String[] args) throws Exception{
        int[][] matrix_sizes = {{5,3},{3,10},{10,6}};
        System.out.println(solution(matrix_sizes));
    }

}
