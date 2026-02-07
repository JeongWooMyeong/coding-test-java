package 이것이코딩테스트다.탐색.이진탐색;

import java.util.*;

public class 이진탐색반복문 {
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == target){
                return mid+1; //찾은 위치 반한
            }else if(arr[mid] > target){
                end = mid - 1; //왼쪽 탐색
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //배열 크기와 찾을 값 입력
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        //반드시 정렬된 배열이어야함
        Arrays.sort(arr);

        int result = binarySearch(arr, target, 0, n-1);

        System.out.print(result);
    }
}
