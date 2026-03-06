package 백준.실버.level2;

import java.util.*;
import java.io.*;


public class 예산 {
    static int n; //지방의 수
    static int[] arr;
    static int m;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        //min = arr[0];
        max = arr[arr.length-1];

        System.out.println(binarySearch(1, max, m, arr));
    }

    static int binarySearch(int start, int end, int target, int[] arrs){
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i=0;i<arrs.length;i++){
                if(arrs[i] >= mid){
                    sum += mid;
                }else{
                    sum += arrs[i];
                }
            }

            if(sum > target) end = mid -1;
            else{
                result = mid;
                start = mid + 1;
            }

        }

        return result;
    }

}
