package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퇴사2 {

    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+2];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            T[i] = t;
            P[i] = p;
        }

        for(int i=N;i>=1;i--){
            if(i + T[i] <= N+1){
                dp[i] = Math.max(dp[i+T[i]] + P[i], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }


        System.out.println(dp[1]);
    }

}
