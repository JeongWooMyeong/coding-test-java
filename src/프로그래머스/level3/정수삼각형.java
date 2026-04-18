package 프로그래머스.level3;

import java.util.*;
import java.io.*;


public class 정수삼각형 {
    static int[][] dp;

    public static int solution(int[][] triangle){
        int n = triangle.length;
        int m = 0;

        dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        //dp[1][0] = dp[0][0] + triangle[1][0];
        //dp[1][1] = dp[0][0] + triangle[1][1];

        for(int i=1;i<n;i++){
            //삼각형이니 i까지의 범위
            for(int j=0;j<=i;j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == m-1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for(int j=0;j<n;j++){
            answer =Math.max(answer, dp[n-1][j]);
        }

        return answer;


    }

    public static void main(String[] args) throws Exception{
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        System.out.println(solution(triangle));
    }

}
