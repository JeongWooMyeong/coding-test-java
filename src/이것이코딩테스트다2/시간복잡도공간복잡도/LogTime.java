package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;
/*
O(log n) 로그시간
이진 탐색, 이진트리
 */

public class LogTime {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        //이진 탐색 -> O(log n)
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                System.out.println("찾음: " + mid);
                break;
            } else if(arr[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
    }
}
