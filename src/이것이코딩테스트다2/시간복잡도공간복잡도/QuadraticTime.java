package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;
/*
O(n2)
이중반복문
 */

public class QuadraticTime {
    public static void main(String[] args){
        int[] arr = {3, 1, 4};

        //모든 쌍 출력 -> O(n2)
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }
}
