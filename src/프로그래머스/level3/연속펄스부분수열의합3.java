package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 연속펄스부분수열의합3 {

    static int[] pulse1;
    static int[] pulse2;
    static int n;
    static long[] dp1;
    static long[] dp2;

    public static long solution(int[] sequence){
        long answer = 0;
        n = sequence.length;
        pulse1 = new int[n];
        pulse2 = new int[n];
        dp1 = new long[n];
        dp2 = new long[n];

        if(n == 1) return Math.max(sequence[0], sequence[0] * -1);

        for(int i=0;i<n;i++){
            pulse1[i] = i % 2 == 0 ? sequence[i] : sequence[i] * -1;
            pulse2[i] = i % 2 == 0 ? sequence[i] * -1 : sequence[i];
        }

        dp1[0] = pulse1[0];
        dp2[0] = pulse2[0];
        //카데인 알고리즘 활용
        for(int i=1;i<n;i++){
            dp1[i] = Math.max(pulse1[i], dp1[i-1] + pulse1[i]);
            dp2[i] = Math.max(pulse2[i], dp2[i-1] + pulse2[i]);
        }

        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;

        for(int i=1;i<n;i++){
            max1 = Math.max(max1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
        }

        answer = Math.max(max1, max2);

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] sequence = {2,3,-6,1,3,-1,2,4};
        System.out.println(solution(sequence));
    }

}
