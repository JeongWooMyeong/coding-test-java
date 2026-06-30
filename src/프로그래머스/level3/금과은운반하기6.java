package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 금과은운반하기6 {

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t){
        long left = 0;
        long right = (long)1e15;
        long answer = 0;


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

    static boolean can(int a, int b, int[] g, int[] s, int[] w, int[] t, long target){
        long gold = 0;
        long silver = 0;
        long total = 0;

        for(int i=0;i<t.length;i++){
            long repeatCount = target / (t[i] * 2L);
            if(target % (t[i] * 2L) >= t[i]) repeatCount++;

            long maxCarry = repeatCount * w[i];

            gold += Math.min(g[i], maxCarry);
            silver += Math.min(s[i], maxCarry);
            total += Math.min(g[i]+s[i], maxCarry);
        }

        return gold >= a && silver >= b && total >= (a+b);
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
