package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 정수삼각형3 {
    static int n;
    static int[][] dp;
    static int[][] map;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //dp 값 초기화
        dp[0][0] = map[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0 ){
                    //맨왼쪽
                    dp[i][j] = map[i][j] + dp[i-1][j];
                }else if(j == i){
                    //맨 오른쪽
                    dp[i][j] = map[i][j] + dp[i-1][j-1];
                }else{
                    //중간
                    dp[i][j] = map[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        for(int j=0;j<n;j++){
            result = Math.max(result, dp[n-1][j]);
        }

        System.out.print(result);


    }

}
