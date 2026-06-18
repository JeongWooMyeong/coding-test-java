package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연속펄스부분수열의합4 {

    static long[] pulse1;
    static long[] pulse2;
    static long[] dp1;
    static long[] dp2;
    static int n;

    public static long solution(int[] sequence){
        n = sequence.length;

        pulse1 = new long[n];
        pulse2 = new long[n];
        dp1 = new long[n];
        dp2 = new long[n];

        for(int i=0;i<n;i++){
            pulse1[i] = ((i % 2 == 0) ? 1 : -1) * sequence[i];
            pulse2[i] = ((i % 2 == 0) ? -1 : 1) * sequence[i];
        }

        dp1[0] = pulse1[0];
        dp2[0] = pulse2[0];

        for(int i=1;i<n;i++){
            dp1[i] = Math.max(pulse1[i], dp1[i-1] + pulse1[i]);
            dp2[i] = Math.max(pulse2[i], dp2[i-1] + pulse2[i]);
        }

        long answer = Long.MIN_VALUE;

        for(int i=0;i<n;i++){
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] sequence = {2,3,-6,1,3,-1,2,4};
        System.out.println(solution(sequence));
    }

}
