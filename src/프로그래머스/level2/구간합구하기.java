package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 구간합구하기 {

    static int[] prefix;
    static int N,M;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();

        for(int a=0;a<M;a++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(prefix[j] - prefix[i-1]).append("\n");
        }


        System.out.println(sb.toString());

    }

}
