package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 스와프2 {
    public static void main(String[] args){
        int[] arr = {3, 5};

        //스와프 (SWAP)
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

        System.out.println(arr[0] + " " + arr[1]);
    }
}
