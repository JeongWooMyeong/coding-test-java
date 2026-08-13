package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 평범한배낭 {

    static int N,K;
    static int[] dp;
    static List<bag> list;
    static class bag{
        int weight;
        int value;

        public bag(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new bag(w,v));
        }

        dp = new int[K+1];

        for(bag b : list){
            for(int j=K;j>=b.weight;j--){
                dp[j] = Math.max(dp[j], dp[j-b.weight] + b.value);
            }
        }

        System.out.println(dp[K]);
    }

}
