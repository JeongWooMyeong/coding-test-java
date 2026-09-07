package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class LCS2 {

    static int[][] dp;
    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        n = str1.length();
        m = str2.length();

        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }

}
