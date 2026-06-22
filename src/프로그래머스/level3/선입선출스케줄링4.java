package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 선입선출스케줄링4 {

    public static int solution(int n, int[] cores){
        long answer = 0;
        long left = 0;
        long right = 0;

        for(int x : cores){
            right = Math.max(right, x);
        }
        right *= n;

        while(left <= right){
            long mid = (left + right) / 2;

            if(getCount(cores, mid) >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        long before = getCount(cores, answer-1);
        for(int i=0;i<cores.length;i++){
            if(answer % cores[i] == 0){
                before++;
                if(before == n) return i + 1;
            }
        }

        return -1;
    }


    static long getCount(int[] cores, long time){
        long count = 0;

        for(int i=0;i<cores.length;i++){
            count += time / cores[i] + 1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[] cores = {1,2,3};

        System.out.println(solution(n, cores));
    }

}
