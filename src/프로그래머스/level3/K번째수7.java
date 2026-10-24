package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class K번째수7 {

    static long N,K;
    static long answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());

        answer = 0;

        long left = 1;
        long right = N * N;

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
