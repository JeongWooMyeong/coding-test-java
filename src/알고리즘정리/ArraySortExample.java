package 알고리즘정리;

import java.util.*;

public class ArraySortExample {
    public static void main(String[] args){
        Integer[] arr = {5, 2, 9, 1};

        //오름차순
        Arrays.sort(arr);
        System.out.println("오름차순: " + Arrays.toString(arr));

        //내림차순
        Arrays.sort(arr, (a,b) -> b - a);
        System.out.println("내림차순: " + Arrays.toString(arr));

        //절댓값 기준
        Arrays.sort(arr, (a, b) -> Math.abs(a) - Math.abs(b));
        System.out.println("절댓값 기준 : " + Arrays.toString(arr));
    }
}
