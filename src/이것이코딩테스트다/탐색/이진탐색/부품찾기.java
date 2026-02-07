package 이것이코딩테스트다.탐색.이진탐색;

import java.util.*;
import java.io.*;

public class 부품찾기 {
    public static String binarySearch(int[] arr, int target, int start, int end){
        while(start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return "yes";
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return "no";

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()), 0, N-1)).append(" ");
        }

        System.out.print(sb);
    }
}
