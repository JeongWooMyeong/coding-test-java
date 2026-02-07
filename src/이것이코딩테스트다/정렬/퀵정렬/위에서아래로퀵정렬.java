package 이것이코딩테스트다.정렬.퀵정렬;

import java.util.*;

public class 위에서아래로퀵정렬 {
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left <= right){
            //내림차순 -> pivot보다 큰 값은 왼쪽으로
            while(left <= end && arr[left] >= arr[pivot]) left++;
            while(right > start && arr[right] <= arr[pivot]) right--;

            if(left > right){
                //pivot과 right 교환
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else{
                //left와 right 교환
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right+1, end);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, N-1);

        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
