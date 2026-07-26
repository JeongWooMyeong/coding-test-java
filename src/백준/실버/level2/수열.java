package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 수열 {

    static int N,K;
    static int[] prefix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;

//        for(int i=1;i<=N-K;i++){
//            int j = i + K;
//            answer = Math.max(answer, prefix[j] - prefix[i]);
//        }
        for(int i=K;i<=N;i++){
            answer = Math.max(answer, prefix[i] - prefix[i-K]);
        }


        System.out.println(answer);
    }

}
