package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 수찾기2 {
    static int[] A;
    static int N,M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //이진탐색을 위한 정렬
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        int left = 0;
        int right = A.length-1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            int answer = binarySearch(left,right,A, target);
            sb.append(answer).append("\n");
        }


        System.out.println(sb.toString());
    }

    static int binarySearch(int left, int right, int[] A, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target) return 1;

            if(A[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return 0;
    }

}
