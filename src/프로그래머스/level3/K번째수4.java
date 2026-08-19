package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class K번째수4 {

    static int N, K;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = N * N;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            int count = 0;
            for(int i=1;i<=N;i++){
                count += Math.min(N, mid / i);
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
