package 백준.플레티넘.level4;

import java.util.*;
import java.io.*;

//동일한거 한번에 사용하면 시간 초과 (10억)
//

public class 평범한배낭 {
    static int N, K;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //이진 분할
            int k = 1;
            while(c > 0){
                //k,c (작은거 선택)
                int num = Math.min(k, c);
                int weight = w * num;
                int value = v * num;

                for(int j=K;j>=weight;j--){
                    dp[j] = Math.max(dp[j], dp[j-weight] + value);
                }

                c -= num;
                k *= 2;

            }

        }

        System.out.print(dp[K]);


    }

}
