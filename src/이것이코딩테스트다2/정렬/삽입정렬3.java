package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 삽입정렬3 {
    public static void main(String[] args){
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=1;i<n;i++){
            //인덱스 i부터 1까지 감소하며 반복하는 문법
            for(int j = i;j>0;j--){
                //한 칸씩 왼쪽으로 이동
                if(arr[j] < arr[j-1]){
                    //스와프 (swap)
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
