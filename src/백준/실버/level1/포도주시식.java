package 백준.실버.level1;

import java.util.*;

public class 포도주시식 {
    static int[] dp;
    static int n;
    static int[] wine;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        wine = new int[n+1];

        for(int i=1;i<=n;i++){
            wine[i] = sc.nextInt();
        }

        dp[1] = wine[1];
        if(n > 1) dp[2] = wine[1] + wine[2];
        if(n > 2) dp[3] = Math.max(Math.max(wine[1] + wine[2], wine[2] + wine[3]), wine[1] + wine[3]);

        for(int i=4;i<=n;i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i]));
        }

        System.out.print(dp[n]);


    }

}
