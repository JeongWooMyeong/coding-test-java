package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연속펄스부분수열의합2 {
    static long[] pulse1;
    static long[] pulse2;
    static long[] dp1;
    static long[] dp2;

    public static long solution(int[] sequence){
        int n = sequence.length;
        if(n==1) return Math.max(sequence[0] * -1, sequence[0] * 1);

        pulse1 = new long[n];    //처음 * 1로 시작
        pulse2 = new long[n];    //처음 * -1로 시작
        dp1 = new long[n];
        dp2 = new long[n];

        for(int i=0;i<n;i++){
            pulse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
            pulse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
        }

        //카데인 알고리즘 이용
        dp1[0] = pulse1[0];
        dp2[0] = pulse2[0];

        for(int i=1;i<n;i++){
            dp1[i] = Math.max(pulse1[i], dp1[i-1] + pulse1[i]);
            dp2[i] = Math.max(pulse2[i], dp2[i-1] + pulse2[i]);
        }

        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max1 = Math.max(dp1[i], max1);
            max2 = Math.max(dp2[i], max2);
        }

        long answer = Math.max(max1, max2);

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] sequence = {2,3,-6,1,3,-1,2,4};
        System.out.println(solution(sequence));
    }

}
