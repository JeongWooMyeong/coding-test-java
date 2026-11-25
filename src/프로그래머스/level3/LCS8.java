package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class LCS8 {

    static int n,m;
    static char[] a;
    static char[] b;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //toCharArray 사용
        String str1 = br.readLine();
        n = str1.length();

        a = new char[n];

        for(int i=0;i<n;i++){
            a[i] = str1.charAt(i);
        }

        String str2 = br.readLine();
        m = str2.length();

        b = new char[m];

        for(int i=0;i<m;i++){
            b[i] = str2.charAt(i);
        }

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
