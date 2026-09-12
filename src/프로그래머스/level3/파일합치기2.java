package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파일합치기2 {

    static int T;
    static int K;
    static int[] file;
    static int[] prefix;
    static int[][] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(T-- > 0){
            K = Integer.parseInt(br.readLine());
            file = new int[K+1];
            prefix = new int[K+1];
            dp = new int[K+1][K+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=K;i++){
                file[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i-1] + file[i];
            }

            for(int i=1;i<=K;i++){
                dp[i][i] = 0;
            }

            for(int len=2;len<=K;len++){
                for(int i=1;i+len-1<=K;i++){
                    int j = i + len - 1;

                    dp[i][j] = Integer.MAX_VALUE;

                    int sum = prefix[j] - prefix[i-1];

                    for(int k=i;k<j;k++){
                        int cost = dp[i][k] + dp[k+1][j] + sum;
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }

                }
            }

            sb.append(dp[1][K]).append("\n");

        }

        System.out.println(sb);
    }

}
