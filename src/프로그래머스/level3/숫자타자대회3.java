package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회3 {

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
    static int[] numarr;

    public static int solution(String numbers){
        dp = new int[10][10][numbers.length()];
        numarr = new int[numbers.length()];
        int answer = 0;

        for(int i=0;i<numbers.length();i++){
            numarr[i] = numbers.charAt(i) - '0';
        }

        for(int[][] d : dp){
            for(int[] d2 : d){
                Arrays.fill(d2, -1);
            }
        }

        answer = dfs(4,6,0);

        return answer;
    }

    static int dfs(int left, int right, int idx){
        if(idx == numarr.length) return 0;
        if(dp[left][right][idx] != -1) return dp[left][right][idx];

        int target = numarr[idx];
        int leftCount = Integer.MAX_VALUE;
        int rightCount = Integer.MAX_VALUE;

        if(right != target){
            leftCount = getCount(left, target) + dfs(target, right, idx+1);
        }

        if(left != target){
            rightCount = getCount(target, right) + dfs(left, target,idx+1);
        }


        return dp[left][right][idx] = Math.min(leftCount, rightCount);
    }

    static int getCount(int a, int target){
        if(a == target) return 1;
        int[] aa = pos[a];
        int[] t = pos[target];

        int dx = Math.abs(aa[0] - t[0]);
        int dy = Math.abs(aa[1] - t[1]);

        int daegak = Math.min(dx,dy);
        int straight = Math.max(dx,dy) - daegak;

        return 3 * daegak + 2 * straight;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";
        System.out.println(solution(numbers));
    }
}
