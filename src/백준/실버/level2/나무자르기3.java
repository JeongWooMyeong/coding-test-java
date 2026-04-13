package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 나무자르기3 {
    static int N, M;
    static int[] arr;
    static long result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        binarySearch(0, arr[N-1]);

        System.out.println(result);

    }

    static void binarySearch(long start, long end){
        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;
            for(int i=0;i<N;i++){
                long remain = arr[i] - mid;
                if(remain < 0){
                    remain = 0;
                }
                sum += remain;
            }

            if(sum >= M){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    }

}
