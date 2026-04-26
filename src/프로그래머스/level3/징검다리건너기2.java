package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 징검다리건너기2 {

    public static int solution(int[] stones, int k){
        int answer = 0;
        int left = 1;
        int right = 1;
        for(int s : stones){
            right = Math.max(s, right);
        }

        while(left <= right){
            int mid = (left + right) / 2;
            if(canCross(mid, stones, k)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


        return answer;
    }

    static boolean canCross(int dist, int[] stones, int target){
        int count = 0;

        for(int s : stones){
            //dist 명이 밟으면 돌이 깨짐
            if(s - dist < 0){
                count++;
                //연속 k이상이면 못건너니 false
                if(count >= target) return false;
            }else{
                //연속 끊김
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
