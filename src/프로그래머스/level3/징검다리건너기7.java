package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 징검다리건너기7 {

    public static int solution(int[] stones, int k){

        int left = 0;
        int right = 0;
        for(int x : stones){
            right = Math.max(right, x);
        }
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(can(mid, stones, k)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }


        return answer;
    }

    static boolean can(int mid, int[] stones, int k){
        int count = 0;
        for(int x : stones){
            if(x - mid < 0){
                count++;
                if(count == k) return false;
            }else{
                count = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

}
