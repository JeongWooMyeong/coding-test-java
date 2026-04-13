package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 암호코드 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        int n = s.length();

        dp = new int[n+1];

        dp[0] = 1;

        for(int i=1;i<=n;i++){
            //한자리
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }

            if(i >= 2){
                int num = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
                if(num >= 10 && num <= 26){
                    dp[i] += dp[i-2];
                    dp[i] %= 1000000;
                }
            }
        }

        System.out.println(dp[n]);

    }

}
