package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;

/*
O(n) - 선형시간
배열/리스트 전체 순회, 선형 탐색
 */

public class LinearTime {
    public static void main(String[] args){
        int[] arr = {5, 2, 9, 1, 7};
        int target = 9;

        //선형 탐색 -> O(n)
        for(int num : arr){
            if(num == target){
                System.out.println("찾음 : " + num);
                break;
            }
        }
    }
}
