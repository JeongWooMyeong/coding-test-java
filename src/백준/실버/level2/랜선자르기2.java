package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 랜선자르기2 {
    static int k,n;
    static int[] arr;
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[k];

        for(int i=0;i<k;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.print(binarySearch(1, max, n, arr));

    }

    static long binarySearch(long start, long end, long target, int[] arrs){
        long result = 0;
        while(start<=end){
            long mid = (start + end) / 2;
            long sum = 0;
            for(int i : arrs){
                sum += i / mid;
            }
            if(sum >= target){
                result = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        return result;
    }

}
