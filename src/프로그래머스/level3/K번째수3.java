package 프로그래머스.level3;

import java.util.*;
import java.io.*;


public class K번째수3 {
    static int N, k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = N * N;
        int answer= 0;

        while(left <= right){
            int mid = (left + right) / 2;
            //mid 이하의 개수를 세기 위함
            int count = 0;
            for(int i=1;i<=N;i++){
                //맨날 볼때마다 헷갈림
                count += Math.min(N, mid / i);
            }

            if(count >= k){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;

            }
        }

        System.out.println(answer);
    }

}
