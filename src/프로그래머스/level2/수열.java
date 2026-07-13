package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 수열 {

    static int N,K;
    static int[] prefix;
    static int answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = Integer.MIN_VALUE;
        prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=K;i<=N;i++){
            int value = prefix[i] - prefix[i-K];
            answer = Math.max(answer, value);
        }

        System.out.println(answer);

    }

}
