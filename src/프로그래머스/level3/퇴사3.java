package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퇴사3 {

    static int N;
    static int[] ti;
    static int[] pi;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ti = new int[N+1];
        pi = new int[N+1];
        dp = new int[N+2];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            ti[i] = Integer.parseInt(st.nextToken());
            pi[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>=1;i--){
            if(i + ti[i] <= N+1){
                dp[i] = Math.max(dp[i+ti[i]] + pi[i], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }


        System.out.println(dp[1]);
    }

}
