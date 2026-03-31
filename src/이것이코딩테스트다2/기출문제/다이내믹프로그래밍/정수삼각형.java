package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

/*
보텀업 작은문제부터 하나씩 반복문
 */

public class 정수삼각형 {
    static int n;   //삼각형 크기
    static int[][] arr;
    static int[][] dp;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        //삼각형 입력 받기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //첫번째 행 초기화
        dp[0][0] = arr[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0){ //맨 왼쪽 끝
                    dp[i][j] = arr[i][j] + dp[i-1][j];
                }else if(j == i){ //맨 오른쪽 끝
                    dp[i][j] = arr[i][j] + dp[i-1][j-1];

                }else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int result = 0;
        for(int i=0;i<=n-1;i++){
            result = Math.max(dp[n-1][i], result);
        }

        System.out.print(result);



    }

}
