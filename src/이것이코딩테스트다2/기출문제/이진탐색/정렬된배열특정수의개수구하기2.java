package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 정렬된배열특정수의개수구하기2 {
    static int N, x;
    static int[] arr;

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

        Arrays.sort(arr);

        int result = 0;
        //결과 값 x값 을 초과하는 처음 인덱스, x값이 처음 나타나는 인덱스
        result = upperBound(arr, x) - lowerBound(arr, x);

        System.out.println(result == 0 ? -1 : result);

    }
    //처음으로 x를 포함하는 인덱스 찾기
    static int lowerBound(int[] arr, int target){
        int start = 0; int end = arr.length;
        while(start < end){ //end 길이에 따라 다름
            int mid = (start + end) / 2;
            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
    //처음으로 x 초과하는 index 찾기
    static int upperBound(int[] arr, int target){
        int start = 0; int end = arr.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

}
