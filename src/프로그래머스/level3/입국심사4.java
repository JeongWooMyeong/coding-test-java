package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 입국심사4 {

    public static long solution(int n, int[] times){
        long answer = 0;
        //심사시간 오름차순 정렬
        Arrays.sort(times);
        long left = 1;
        long right = (long)times[times.length-1] * n;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int t : times){
                count += mid / t;
            }

            if(count >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n, times));
    }

}
