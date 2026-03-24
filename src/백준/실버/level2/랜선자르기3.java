package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 랜선자르기3 {
    static int K, N;
    static int[] arr;

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

        int length = binarySearch(1, arr[K-1], N);
        System.out.print(length);

    }

    static int binarySearch(int start, int end, int target){
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i=0;i<K;i++){
                sum += arr[i] / mid;
            }

            if(target <= sum){
                result = mid;
                start = mid + 1;
            }else{

                end = mid - 1;
            }
        }
        return result;
    }

}
