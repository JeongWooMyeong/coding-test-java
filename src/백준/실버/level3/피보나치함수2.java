package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 피보나치함수2 {
    static int t;
    static int[] arr;
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        arr = new int[t];

        for(int i=0;i<t;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = 1;   //fibonacci(0)에서 0호출
        dp[0][1] = 0;   //fibonacci(0)에서 1호출
        dp[1][0] = 0;   //fibonacci(1)에서 0호출
        dp[1][1] = 1;   //fibonacci(1)에서 1호출

        for(int i=2;i<41;i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i=0;i<t;i++){
            System.out.println(dp[arr[i]][0] + " " + dp[arr[i]][1]);
        }

    }

}
