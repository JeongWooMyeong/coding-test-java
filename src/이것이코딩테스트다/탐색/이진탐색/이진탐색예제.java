package 이것이코딩테스트다.탐색.이진탐색;

import java.util.*;

public class 이진탐색예제 {
    public static int binarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = (start + end) / 2;

        if(arr[mid] == target){
            return mid+1;
        } else if (arr[mid] > target){
            //target이 더 작으면 왼쪽 탐색
            return binarySearch(arr, target, start, mid-1);

        } else {
            //target이 더 크면 오른쪽 탐색
            return binarySearch(arr, target, mid+1, end);
        }
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

        //이진탐색은 반드시 정렬된 배열이어야함
        Arrays.sort(arr);

        int result = binarySearch(arr, target, 0, n-1);

        System.out.print(result);
    }
}
