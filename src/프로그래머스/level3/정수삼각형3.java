package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 정수삼각형3 {
    public static int solution(int[][] triangle){
        int answer = 0;
        int n = triangle.length;

        int[] dp = new int[n];
        dp[0] = triangle[0][0];

        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(j == 0){
                    dp[j] = dp[j] + triangle[i][j];
                }else if(j == i){
                    dp[j] = dp[j-1] + triangle[i][j];
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1]) + triangle[i][j];
                }
            }
        }

        for(int j=0;j<n;j++){
            answer = Math.max(answer, dp[j]);
        }

        return answer;


    }

    public static void main(String[] args) throws Exception{
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        System.out.println(solution(triangle));
    }

}
