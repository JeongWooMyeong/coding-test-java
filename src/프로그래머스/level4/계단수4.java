package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 계단수4 {

    static int N;
    static int[][][] dp;
    static int mod = 1000000000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10][1<<10];
        //근데 왜 0은 안들어갈까? 아.. 0으로 시작하는 수는 계단수가 아니라고 적혀있음
        for(int d=1;d<=9;d++){
            dp[1][d][1<<d] = 1;
        }

        for(int len=2;len<=N;len++){
            for(int d=0;d<=9;d++){
                for(int mask=0;mask<(1<<10);mask++){
                    //이전 숫자가 0 이면 조합할 수 있는게 없음
                    if(dp[len-1][d][mask] == 0) continue;


                    if(d > 0){
                        int newMask = mask | (1<<d-1);
                        dp[len][d-1][newMask] = (dp[len][d-1][newMask] + dp[len-1][d][mask]) % mod;
                    }

                    if(d < 9){
                        int newMask = mask | (1<<d+1);
                        dp[len][d+1][newMask] = (dp[len][d+1][newMask] + dp[len-1][d][mask]) % mod;
                    }

                }
            }
        }

        int ans = 0;
        for(int d=0;d<=9;d++){
            ans = (ans +dp[N][d][(1<<10)-1]) % mod;
        }

        System.out.print(ans);

    }

}
