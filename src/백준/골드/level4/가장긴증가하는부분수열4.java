package 백준.골드.level4;


import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열4 {
    static int N;
    static int[] arr;
    static int[] dp;
    static int[] prev;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        prev = new int[N];

        Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            //dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxLen = 0;
        int lastIdx = 0;
        for(int i=0;i<N;i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        while(lastIdx != -1){
            result.add(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        Collections.reverse(result);


        System.out.println(maxLen);

        for(int x : result){
            System.out.print(x +" ");
        }




    }

}
