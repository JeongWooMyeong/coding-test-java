package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class LCS7 {

    static int[][] dp;
    static int n,m;
    static char[] a;
    static char[] b;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        n = a.length;
        m = b.length;

        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);

    }

}
