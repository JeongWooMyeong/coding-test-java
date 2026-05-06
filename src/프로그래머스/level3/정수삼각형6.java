package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
1차원배열 (열로만 관리)
앞에서부터 하면 관리 힘들므로 뒤에서부터 누적해야함
 */

public class 정수삼각형6 {
    static int[] dp;

    public static int solution(int[][] triangle){
        int answer = 0;
        dp = new int[triangle.length];

        dp[0] = triangle[0][0];

        for(int i=1;i<triangle.length;i++){
            for(int j=triangle[i].length-1;j>=0;j--){
                if(j == 0){
                    dp[j] = dp[j] + triangle[i][j];
                }else if(j == triangle[i].length-1){
                    dp[j] = dp[j-1] + triangle[i][j];
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1]) + triangle[i][j];
                }
            }
        }

        for(int i=0;i<triangle.length;i++){
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        System.out.println(solution(triangle));
    }

}
