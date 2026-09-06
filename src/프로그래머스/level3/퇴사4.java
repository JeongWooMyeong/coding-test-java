package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퇴사4 {

    static int N;
    static int[] Pi;
    static int[] Ti;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Pi = new int[N+1];
        Ti = new int[N+1];
        dp = new int[N+2];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Ti[i] = t;
            Pi[i] = p;
        }

        for(int i=N;i>=1;i--){
            if(i + Ti[i] <= N+1){
                dp[i] = Math.max(dp[i + Ti[i]] + Pi[i], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);

    }

}
