package 백준.플레티넘.level4;

import java.util.*;
import java.io.*;

public class 평범한배낭2 {
    static int N,K;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //민호가 들 수 있는 가방의 최대 무게

        dp = new int[K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //이진분할 사용 -> c의 개수 10000까지 이므로 -> 시간초과
            int k = 1;
            while(c > 0){
                int num = Math.min(k,c);
                int weight = w * num;
                int value = v * num;

                //DP 뒤에서부터 -> 앞에서하면 한번 계산해야할걸 두번 계산함
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
