package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 금광 {
    static int T;
    static int n,m;
    static int[][] dp;
    static int[][] gold;
    static ArrayList<Integer> results = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            result = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            gold = new int[n][m];
            dp = new int[n][m];

            st = new StringTokenizer(br.readLine());

            //금광 정보 입력
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    gold[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = gold[i][j]; //dp 초기값 골드 정보 입력
                }
            }

            //열기준으로 이동 검색
            //열기준으로 검색
            for(int j=1;j<m;j++){
                for(int i=0;i<n;i++){
                    int leftup = 0, left = 0, leftDown = 0;
                    if(i > 0 ) leftup = dp[i-1][j-1];
                    left = dp[i][j-1];
                    if(i < n-1) leftDown = dp[i+1][j-1];

                    dp[i][j] = dp[i][j] + Math.max(leftup, Math.max(left, leftDown));
                }
            }

            for(int i=0;i<n;i++){
                result = Math.max(result, dp[i][m-1]);
            }
            results.add(result);


        }
        //int[] result2 = results.toArray(new Integer[results.size()]);
        for(int x : results){
            System.out.println(x);
        }
    }

}
