package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열 {

    static int N;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

}
