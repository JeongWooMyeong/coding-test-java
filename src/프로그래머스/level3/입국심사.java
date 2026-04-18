package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 입국심사 {
    public static long solution(int n, int[] times){
        long answer = 0;

        Arrays.sort(times);

        long start = 1;
        long end = (long) times[times.length-1] * n;


        while(start <= end){
            long mid = (start + end) / 2;
            long people = 0;
            //if(mid / n)
            for(int time : times){
                people += mid / time;
            }

            if(people >= n){
                //최소값 구하는 것이므로 MAth.min
                answer = mid;
                end = mid -1;
            }else{
                start = mid + 1;
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
