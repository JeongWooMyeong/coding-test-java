package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 징검다리건너기5 {

    public static int solution(int[] stones, int k){
        int answer = 0;
        int left = 0;
        int right = 0;
        for(int x : stones){
            right = Math.max(right, x);
        }

        while(left <= right){
            int mid = (left + right) / 2;

            if(canMove(mid, stones, k)){
                answer = mid;
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return answer;
    }

    static boolean canMove(int people, int[] stones, int k){
        int count = 0;
        for(int s : stones){
            if(s - people < 0){
                count++;
                if(count >= k) return false;
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
