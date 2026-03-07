package 백준.실버.level1;

import java.util.*;

public class 정수삼각형 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j=0;j<=i;j++){
                triangle[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0){//가장 왼쪽
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == i){//가장 오른쪽
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{ //
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.print(result);

    }
}
