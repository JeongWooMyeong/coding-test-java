package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 금광2 {
    static int T;
    static int n,m;
    static int[][] gold; //금광
    static int[][] dp;
    static int result;
    static ArrayList<Integer> results = new ArrayList<>();

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
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    gold[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = gold[i][j];
                }
            }

            //열기준으로 돌면서 확인 j1부터
            for(int j=1;j<m;j++){
                for(int i=0;i<n;i++){
                    int leftUp = 0, left = 0, leftDown = 0;

                    if(i > 0) leftUp = dp[i-1][j-1];
                    left = dp[i][j-1];
                    if(i < n-1) leftDown = dp[i+1][j-1];

                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));

                }
            }

            for(int i=0;i<n;i++){
                result = Math.max(result, dp[i][m-1]);
            }

            results.add(result);

        }

        StringBuilder sb = new StringBuilder();
        for(int x : results){
            sb.append(x).append("\n");
        }

        System.out.print(sb);
    }

}
