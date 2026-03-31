package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.io.*;
import java.util.*;

/*
탑다운 방식 (재귀)
 */

public class 정수삼각형2 {
    static int[][] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  //아직 계산되지 않은 상태
            }
        }

        //꼭대기에서 시작
        System.out.println(recur(0, 0));

    }

    //재귀 함수 (탑다운)
    static int recur(int i, int j){
        //마지막 행에 도달하면 그대로 반환
        if(i == n - 1) return arr[i][j];

        //이미 계산된 값이면 그대로 반환
        if(dp[i][j] != -1) return dp[i][j];

        //대각 선 왼쪽 / 오른ㅉ?ㅗㄱ으로 내려가기
        int left = recur(i +1, j);
        int right = recur(i+1, j+1);
        //현재 값 + 두 경로중 최댓값
        dp[i][j] = arr[i][j] + Math.max(left,right);
        return dp[i][j];
    }

}
