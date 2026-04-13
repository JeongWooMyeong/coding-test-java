package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 평범한배낭4 {
    static int N, K;
    static List<Integer> Weights = new ArrayList<>();
    static List<Integer> Values = new ArrayList<>();
    static int[] dp;    //무게의 합

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

            Weights.add(w);
            Values.add(v);
        }

        for(int i=0;i<N;i++){
            int w = Weights.get(i);
            int v = Values.get(i);
            //역순 이유 : 물건 중복으로 들어가는거 방지
            for(int j=K;j>=w;j--){
                //w무게 포함 , 포함안할때
                dp[j] = Math.max(dp[j], dp[j-w] + v);
               // System.out.println(dp[j]);
            }
        }

        System.out.println(dp[K]);



    }


}
