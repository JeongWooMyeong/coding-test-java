package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회14 {

    static int n;
    static int[] numarr;
    static int[][][] dp;
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

    public static int solution(String numbers){
        n = numbers.length();
        numarr = new int[n];

        for(int i=0;i<n;i++){
            numarr[i] = numbers.charAt(i) - '0';
        }

        dp = new int[10][10][n];

        for(int[][] d1 : dp){
           for(int[] d2 : d1){
               Arrays.fill(d2, -1);
           }
        }

        return dfs(4,6,0);

    }

    static int dfs(int left, int right, int idx){
        if(idx == n){
            return 0;
        }

        if(dp[left][right][idx] != -1){
            return dp[left][right][idx];
        }

        int target = numarr[idx];

        int leftCount = Integer.MAX_VALUE;
        int rightCount = Integer.MAX_VALUE;

        if(target != right){
            leftCount = getCount(left, target) + dfs(target, right, idx+1);
        }

        if(target != left){
            rightCount = getCount(right, target) + dfs(left, target, idx+1);
        }

        return dp[left][right][idx] = Math.min(leftCount, rightCount);
    }

    static int getCount(int a1, int b1){

        if(a1 == b1) return 1;

        int[] a = pos[a1];
        int[] b = pos[b1];

        int dx = Math.abs(a[0] - b[0]);
        int dy = Math.abs(a[1] - b[1]);

        int daegak = Math.min(dx,dy);
        int straight = Math.max(dx,dy) - daegak;

        return 3 * daegak + 2 * straight;

    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";
        System.out.println(solution(numbers));
    }

}
