package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 수찾기 {
    static int n, m;
    static Integer[] arr, arr2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //이진탐색은 정렬 필수
        Arrays.sort(arr, (a,b) -> a - b);

        m = Integer.parseInt(br.readLine());

        arr2 = new Integer[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = binarySearch(0, n-1, Integer.parseInt(st.nextToken()));
        }

        for(int x : arr2){
            System.out.println(x);
        }


    }

    public static int binarySearch(int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return 1;
            else if(arr[mid] < target) start = mid + 1;
            else end = mid -1;
        }

        return 0;
    }

}
