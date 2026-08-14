package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 평범한배낭2 {

    static int N,K;
    static int[] dp;
    static List<Bag> list;
    static class Bag{
        int weight;
        int value;

        public Bag(int weight, int value){
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
        dp = new int[K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Bag(w,v));
        }

        for(Bag bag : list){
            for(int j=K;j>=bag.weight;j--){
                dp[j] = Math.max(dp[j], dp[j-bag.weight] + bag.value);
            }
        }

        System.out.println(dp[K]);
    }

}
