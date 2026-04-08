package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class LCS3 {
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();

        dp = new int[n+1][m+1]; //a의 길이 / b의 길이

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.print(dp[n][m]);
    }

}
