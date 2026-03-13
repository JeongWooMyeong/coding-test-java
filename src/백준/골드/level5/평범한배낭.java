package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 평범한배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n+1];
        int[] value = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k+1];

        for(int i=1;i<=n;i++){
            //역순 중복방지
            for(int w =k;w>=weight[i];w--){
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
                System.out.println("i:" + i + "w:"+dp[w] +"w2:" + w);
            }
        }

        System.out.println(dp[k]);
    }
}
