package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 동전1 {
    static int n,k;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[k+1];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int coin : arr){
            for(int s=coin;s<=k;s++){
                dp[s] += dp[s-coin];
            }
        }

        System.out.print(dp[10]);
    }

}
