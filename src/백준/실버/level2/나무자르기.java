package 백준.실버.level2;

import java.util.*;

public class 나무자르기 {
    public static int n, m;
    public static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //초기화를 안해주네 계속..
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = binarySearch(1, arr[n-1], m, arr);
        System.out.print(result);
    }

    public static int binarySearch(int start, int end, int target, int[] arr){
        int result = 0;
        while(start<=end){
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                //int remain = arr[i] - mid;
                //if(remain < 0) remain = 0;
                //sum += remain;
                if(arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }
            //if(sum == target) return mid;
            //else if(sum > target) start = mid +1;
            //else end = mid - 1;
            if(sum >= target){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return result;
    }

}
