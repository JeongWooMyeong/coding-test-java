package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 숫자카드 {
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        int n = str.length();

        dp = new int[n+1];

        dp[0] = 1;

        for(int i=1;i<=n;i++){
            //1자리 일때
            if(str.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            //2자리일때
            if(i>=2){
                int num = (str.charAt(i-2) - '0') * 10 + (str.charAt(i-1) -'0');

                if(num >= 10 && num <= 34){
                    dp[i] += dp[i-2];
                }

            }
        }

        System.out.println(dp[n]);

    }
}
