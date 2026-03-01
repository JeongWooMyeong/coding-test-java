package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 퀵정렬5 {
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;    //원소가 1개인 경우 종료
        int pivot = start;  //피벗은 첫번째 원소
        int left = start + 1;
        int right = end;
        while(left <= right){
            //피벗보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left++;
            //피벗보다 작은 데이터를 찾을 때까지 반복
            while(right > start && arr[right] >= arr[pivot]) right--;
            //엇갈렸다면 작은 데이터와 피벗을 교체
            if(left > right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }
}
