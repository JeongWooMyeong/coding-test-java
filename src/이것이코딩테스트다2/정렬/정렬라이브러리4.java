package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 정렬라이브러리4 {
    public static void main(String[] args){
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
