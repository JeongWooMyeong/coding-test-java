package 삼성SW역량테스트.실버.level3;

import java.util.*;
import java.io.*;


public class 퇴사 {
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
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>=1;i--){
            if(T[i] + i <= N+1){
                dp[i] = Math.max(P[i] + dp[T[i] + i], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.print(dp[1]);
    }

}
