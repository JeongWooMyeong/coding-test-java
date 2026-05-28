package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 선입선출스케줄링 {

    public static int solution(int n, int[] cores){
        int max = Integer.MIN_VALUE;

        for(int x : cores){
            max = Math.max(x, max);
        }

        long left = 1;
        long right = (long)max * n;
        long time = 0;
        //최소 시간 찾기
        while(left <= right){
            long mid = (left + right) / 2;
            long count = getCount(mid, cores);

            if(count >= n){
                time = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        //최소 시간 찾은다음에 번호 찾아야함
        long before = getCount(time-1, cores);
        for(int i=0;i<cores.length;i++){
            if(time % cores[i] == 0){
                before++;
                if(before == n) return i +1;
            }
        }

        return -1;
    }

    static long getCount(long time, int[] cores){
        long count = 0;
        for(int core : cores){
            count += (time / core) + 1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[] cores = {1,2,3};
        System.out.println(solution(n, cores));
    }

}
