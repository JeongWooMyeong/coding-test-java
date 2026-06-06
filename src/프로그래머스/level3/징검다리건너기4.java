package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 징검다리건너기4 {

    public static int solution(int[] stones, int k){
        int answer = 1;
        int left = 1;
        int right = 1;
        for(int s : stones){
            right = Math.max(right, s);
        }

        while(left <= right){
            int mid = (left + right) / 2;
            if(canMove(mid, stones, k)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }

        return answer;

    }

    static boolean canMove(int people, int[] stones, int k){
        int count = 0;
        for(int s : stones){
            //돌 크기 - 사람수 음수이면 갈수 있따는 뜻
            if(s - people < 0){
                count++;
                //연속적인게 k이상이면 false
                if(count >= k) return false;
            }else{
                //아니라면 count 초기화
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
