package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 정렬된배열특정수의개수구하기 {
    static int N, x;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //원래라면 이진탐색은 정렬해줘야하지만 문제에서는 이미 정렬해줬음
        Arrays.sort(arr);

        int lowerbound = lowerbound(0, N, x, arr);
        int upperbound = upperbound(0, N, x, arr);

        int result = upperbound - lowerbound;

        System.out.print(result == 0 ? -1 : result);


    }

    static int lowerbound(int start, int end, int target, int[] arr){
        while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] >= target) {
                end = mid;
            } else start = mid + 1;
        }

        return start;
    }

    static int upperbound(int start, int end, int target, int[] arr){
        while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] > target) {
                end = mid;
            } else start = mid + 1;
        }

        return start;
    }

}
