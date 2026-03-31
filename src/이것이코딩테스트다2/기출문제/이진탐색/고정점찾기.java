package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 고정점찾기 {
    static int N;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //고정 점 찾기라 타겟 넣을 필요 없을듯?
        result = BinarySearch(0, N, arr);
        System.out.print(result == 0 ? -1 : result);
    }

    static int BinarySearch(int start, int end, int[] arr){
        while(start < end){
            int mid = (start + end ) / 2;
            if(mid == arr[mid]) return mid;
            if(mid > arr[mid]) start = mid + 1;
            else end = mid -1;
        }

        return start;
    }

}
