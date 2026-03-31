package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 고정점찾기2 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = BinarySearch(0, N-1, arr);

        System.out.print(result);
    }

    static int BinarySearch(int start, int end, int[] arr){
        while(start <= end){
            int mid = (start + end) / 2;
            if(mid == arr[mid]) return mid;
            if(mid > arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

}
