package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회12 {

    static long[][][] dp;
    static long answer;
    static int[][] pos = {
            {3,1},
            {0,0},
            {0,1},
            {0,2},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2}
    };
    static int[] numarr;

    public static int solution(String numbers){
        answer = 0;

        dp = new long[10][10][numbers.length()];
        numarr = new int[numbers.length()];

        for(int i=0;i<numbers.length();i++){
            numarr[i] = numbers.charAt(i) - '0';
        }

        for(long[][] d1: dp){
            for(long[] d2: d1){
                Arrays.fill(d2, -1);
            }
        }

        answer = dfs(4,6,0);

       return (int)answer;

    }

    static long dfs(int left, int right, int idx){
        if(idx == numarr.length){
            return 0;
        }

        if(dp[left][right][idx] != -1){
            return dp[left][right][idx];
        }

        int target = numarr[idx];
        long leftCount = Long.MAX_VALUE;
        long rightCount = Long.MAX_VALUE;

        if(target != right){
            leftCount = getCount(left, target) + dfs(target, right, idx+1);
        }

        if(target != left){
            rightCount = getCount(right, target) + dfs(left, target, idx+1);
        }

        return dp[left][right][idx] = Math.min(leftCount, rightCount);

    }

    static long getCount(int a, int b){
        if(a == b) return 1;    //제자리
        int[] a1 = pos[a];
        int[] b1 = pos[b];

        long dx = Math.abs(a1[0] - b1[0]);
        long dy = Math.abs(a1[1] - b1[1]);

        long daegak = Math.min(dx,dy);
        long straight = Math.max(dx,dy) - daegak;

        return 3 * daegak + 2 * straight;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";
        System.out.println(solution(numbers));
    }

}
