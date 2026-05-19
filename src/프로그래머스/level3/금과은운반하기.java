package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 금과은운반하기 {

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t){
        //금과 은을 운반하는데 걸리는 시간 mid
        long left = 1;
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
            //2를 long으로 표현
            long trip = target / (t[i] * 2L);
            if(target % (t[i] * 2L) >= t[i]) trip++;

            long maxCarry = trip * w[i];

            //금, 운 각각 운반 가능한 최대치
            long carryGold = Math.min(g[i], maxCarry);
            long carrySilver = Math.min(s[i], maxCarry);

            gold += carryGold;
            silver += carrySilver;

            total += Math.min(g[i] + s[i], maxCarry);

        }

        return gold >= a && silver >= b && total >= (a+b);

    }

    public static void main(String[] args) throws Exception{
        int a = 10;
        int b = 10;
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};

        System.out.println(solution(a,b,g,s,w,t));
    }

}
