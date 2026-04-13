package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 랜선자르기4 {
    static int N, K;
    static int[] arr;
    static long result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];

        for(int i=0;i<K;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        //1로 시작해야하네..
        binarySearch(1, arr[K-1]);

        System.out.println(result);
    }

    static void binarySearch(long start, long end){
        while(start <= end){
            long mid = (start + end) / 2;

            long sum = 0;
            for(int i=0;i<K;i++){
                sum += arr[i] / mid;
            }

            if(sum >= N){
                result = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }

        }
    }

}
