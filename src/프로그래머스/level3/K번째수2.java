package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class K번째수2 {

    static int n, k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = n * n;
        int answer = Integer.MIN_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;

            for(int i=1;i<=n;i++){
                count += Math.min(mid / i, n);
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
