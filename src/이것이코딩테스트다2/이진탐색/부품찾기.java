package 이것이코딩테스트다2.이진탐색;

import java.util.*;

public class 부품찾기 {
    //이진탐색 (반복문)
    public static String binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return "yes";
            else if(arr[mid] > target) end = mid -1;
            else start = mid + 1;
        }

        return "no";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();

        for(int i=0;i<m;i++){
            System.out.print(binarySearch(arr, sc.nextInt(), 0, n-1) + " ");
        }



    }
}
