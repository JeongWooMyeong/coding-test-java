package 알고리즘정리2;

import java.util.*;

public class CombinationExample2 {
    static int[] arr = {1,2,3,4};
    static int[] result = new int[2];

    public static void main(String[] args){
        comb(0, 0);
    }

    static void comb(int depth, int start){
        if(depth == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i=start;i<arr.length;i++){
            result[depth] = arr[i];
            comb(depth + 1, i + 1);
        }
    }
}
