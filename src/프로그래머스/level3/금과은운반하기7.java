package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 금과은운반하기7 {

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t){
        long answer = 0;

        long left = 0;
        long right = (long) 1e15;

        while(left <= right){
            long mid = (left + right) / 2;

            if(can(a,b,g,s,w,t,mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }


        return answer;
    }

    static boolean can(int a, int b, int[] g, int[] s, int[] w, int[] t, long mid){
        long gold = 0;
        long silver = 0;
        long total = 0;

        for(int i=0;i<t.length;i++){
            long repeatCount = mid / (t[i] * 2L);
            if(mid % (t[i] * 2L) >= t[i]) repeatCount += 1;

            long maxCarry = w[i] * repeatCount;

            gold += Math.min(g[i], maxCarry);
            silver += Math.min(s[i], maxCarry);
            total += Math.min(g[i] + s[i], maxCarry);

        }

        return gold >= a && silver >= b && total >= a+b;
    }


    public static void main(String[] args) throws Exception{
        int a = 90;
        int b = 500;
        int[] g = {70,70,0};
        int[] s = {0,0,500};
        int[] w = {100,100,2};
        int[] t = {4,8,1};
        System.out.println(solution(a,b,g,s,w,t));
    }

}
