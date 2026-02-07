package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

public class 기본라이브러리예제 {
    public static void main(String[] args){
        int[] arr = {7, 5, 9 , 0, 3, 1, 6, 2, 4, 8};

        //기본 정렬 라이브러리 사용
        Arrays.sort(arr);

        //결과 출력
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
