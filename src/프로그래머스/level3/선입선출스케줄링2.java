package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 선입선출스케줄링2 {

    public static int solution(int n, int[] cores){
        int max = Integer.MIN_VALUE;

        for(int x : cores){
            max = Math.max(max, x);
        }

        long left = 1;
        long right = (long) max * n;
        long time = 0;

        while(left <= right){
            //작업하는데 걸린 시간
            long mid = (left + right) / 2;

            long count = getCount(mid, cores);

            if(count >= n){
                time = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }


        //근데 mid가 아닌 작업 번호를 구해야함
        //구한 최소 시간중에서 time -1 을 구해서 작업 번호 찾아야함
        //time-1 까지 완료한 작업 개수
        long before = getCount(time -1, cores);
        for(int i=0;i<cores.length;i++){
            if(time % cores[i] == 0){
                before++;
                if(before == n) return i+1;
            }
        }

        return -1;
    }

    static long getCount(long mid, int[] cores){
        long count = 0;
        for(int i=0;i<cores.length;i++){
            //최초에 모든작업이진행
            count += mid / cores[i] + 1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[] cores = {1,2,3};
        System.out.println(solution(n, cores));
    }

}
