package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;

/*
O(n!)
순열 생성 (백트래킹)
순열 : 순서 고려 한 경우의 수
 */

public class FactorialTime {
    public static void permute(List<Integer> nums, int l, int r){
        if(l == r){
            System.out.println(nums);
        }else{
            for(int i= l; i<=r;i++){
                Collections.swap(nums, l, i);
                permute(nums, l + 1, r);
                Collections.swap(nums, l, i);
            }
        }
    }

    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(1, 2, 3);
        permute(nums, 0, nums.size() - 1);  //O(n!)
    }
}
