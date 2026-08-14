package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연속펄스부분수열의합9 {

    static long answer;
    static int n;
    static long[] pulse1;
    static long[] pulse2;
    static long[] dp1;
    static long[] dp2;

    public static long solution(int[] sequence){

        answer = Long.MIN_VALUE;

        n = sequence.length;

        pulse1 = new long[n];
        pulse2 = new long[n];

        for(int i=0;i<n;i++){
            pulse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
            pulse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
        }

        dp1 = new long[n];
        dp2 = new long[n];

        dp1[0] = pulse1[0];
        dp2[0] = pulse2[0];

        for(int i=1;i<n;i++){
            dp1[i] = Math.max(pulse1[i], dp1[i-1] + pulse1[i]);
            dp2[i] = Math.max(pulse2[i], dp2[i-1] + pulse2[i]);
        }

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
