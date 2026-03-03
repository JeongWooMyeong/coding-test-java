package 이것이코딩테스트다2.이진탐색;

import java.util.*;

public class 부품찾기3 {
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return -1;
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
        String result = "";
        for(int i=0;i<m;i++){
            int a = binarySearch(arr, sc.nextInt(), 0, n-1);
            if(a == -1){
                result += "no ";
            }else{
                result += "yes ";
            }
        }

        System.out.println(result);


    }
}
