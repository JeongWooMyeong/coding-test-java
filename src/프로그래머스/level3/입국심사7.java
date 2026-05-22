package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 입국심사7 {

    public static long solution(int n, int[] times){
        long answer = 0;

        Arrays.sort(times);

        long left = 1;
        long right = n * (long)times[times.length-1];

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int i=0;i<times.length;i++){
                count += mid / times[i];
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
