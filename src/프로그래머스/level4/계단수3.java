package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 계단수3 {

    static int N;
    static int[][][] dp;
    static int mod = 1000000000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][10][1<<10];

        for(int d=1;d<=9;d++){
            dp[1][d][1<<d] = 1;
        }

        for(int len=2;len<=N;len++){
            for(int d=0;d<=9;d++){
                for(int mask=0;mask<(1<<N);mask++){
                    if(dp[len-1][d][mask] == 0) continue;

                    if(d > 0){
                        int newmask = mask | (1<<(d-1));
                        dp[len][d-1][newmask] = (dp[len][d-1][newmask] + dp[len-1][d][mask]) % mod;
                    }

                    if(d < 9){
                        int newmask = mask | (1<<(d+1));
                        dp[len][d+1][newmask] = (dp[len][d+1][newmask] + dp[len-1][d][mask]) % mod;
                    }

                }
            }
        }

        int answer = 0;

        for(int d=0;d<=9;d++){
            answer = (answer + dp[N][d][(1<<N)-1]) % mod;
        }

        System.out.println(answer);
    }

}
