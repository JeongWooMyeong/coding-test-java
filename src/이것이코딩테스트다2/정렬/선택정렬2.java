package 이것이코딩테스트다2.정렬;

import java.util.*;

/*
선택정렬 :가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고 그다음 작은 데이터를
선택해 앞에서 두번째 데이터와 바꾸는 과정
스와프 과정 필요

 */
public class 선택정렬2 {
    public static void main(String[] args){
        int n= 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=0;i<n;i++){
            int min_index = i; //가장 작은 원소의 인덱스
            for(int j=i+1;j<n;j++){
                if(arr[min_index] > arr[j]){
                    min_index = j;
                }
            }

            //스와프
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;


        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
