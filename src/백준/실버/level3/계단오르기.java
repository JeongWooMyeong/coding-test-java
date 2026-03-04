package 백준.실버.level3;

import java.util.*;

public class 계단오르기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1];
        if(n >= 2) dp[2] = stair[1] + stair[2];

        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
        }

        System.out.println(dp[n]);

    }
}
