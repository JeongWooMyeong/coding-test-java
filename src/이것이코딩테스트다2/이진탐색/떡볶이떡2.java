package 이것이코딩테스트다2.이진탐색;

import java.util.*;

public class 떡볶이떡2 {

        public static int binarySearch(int[] arr, int target){
            int start = 0;
            int end = arr[arr.length-1];


            int result = 0;
            while(start <= end){
                int total = 0;
                int mid = (start + end) / 2;
                for(int i=0;i<arr.length;i++){
                    if(arr[i] > mid) total += arr[i] - mid;
                }
                if(total < target) end = mid -1;
                else{
                    result = mid;
                    start = mid + 1;
                }

            }
            return result;
        }


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr= new int[n];

            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            System.out.print(binarySearch(arr, m));

        }
}
