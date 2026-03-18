package 백준.골드.level1;

import java.util.*;
import java.io.*;


public class K번째수3 {
    static int N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long left = 0;
        long right = K;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;

            for(int i=1;i<=N;i++){
                count += Math.min(mid / i, N);
            }

            if(count >= K){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }


        }

        System.out.println(answer);

    }
}
