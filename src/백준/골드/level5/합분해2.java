package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 합분해2 {
    static int N,K;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //dp[N][K] -> K개를 가지고 N을 만드는 과정

        dp = new int[N+1][K+1];

        for(int i=0;i<=N;i++){
            dp[i][1] = 1;   //n을 한개 가지고 만들 수 있는건 자기 자신
        }

        for(int i=1;i<=K;i++){
            dp[0][i] = 1;   //i개 가지고 0을 만들 수 있는 경우는 1
        }

        //dp[i][j-1] : i를 j개의 수로 표현하는데 마지막 수가 0이라면 -> 나머지 i를 j-1개의 수로 표현
        //ex) {3,0}
        //dp[i-1][j]- 1을빼면 두가지 경우줒ㅇ에 예를들어 2를 만드는 경우나 아니며 i-1을 만드는 경우랑 같구나..
        for(int i=1;i<=N;i++){
            for(int j=2;j<=K;j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }

}
