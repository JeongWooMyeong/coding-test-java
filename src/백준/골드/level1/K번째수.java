package 백준.골드.level1;

import java.util.*;
import java.io.*;

public class K번째수 {
    static int N, K;
    static int[] B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int idx = 0;
        B = new int[N*N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                B[idx] = i * j;
                idx++;
            }
        }

        Arrays.sort(B);

        System.out.println(B[K]);

    }

}
