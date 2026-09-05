package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 정수삼각형14 {

    static int n;
    static int[][] dp;

    public static int solution(int[][] triangle){
        n = triangle.length;

        dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == triangle[i].length-1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0;i<triangle.length;i++){
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        System.out.println(solution(triangle));
    }



}
