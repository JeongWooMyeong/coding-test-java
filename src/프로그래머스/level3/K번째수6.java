package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class K번째수6 {

    static int N,K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long left = 0;
        long right = (long)N * N;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            long count = 0;

            for(int i=1;i<=N;i++){
                count += Math.min(mid / i, N);
            }

            if(count >= K){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        System.out.println(answer);
    }

}
