package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class LCS4 {

    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        dp = new int[c1.length+1][c2.length+1];

        for(int i=1;i<=c1.length;i++){
            for(int j=1;j<=c2.length;j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=c1.length;i++){
            for(int j=1;j<=c2.length;j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);

    }

}
