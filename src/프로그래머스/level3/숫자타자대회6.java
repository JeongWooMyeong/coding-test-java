package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회6 {

    static int[][][] dp;
    static int[] numarr;
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
    static int INF = (int) 1e9;

    public static int solution(String numbers){
        numarr = new int[numbers.length()];

        for(int i=0;i<numbers.length();i++){
            numarr[i] = numbers.charAt(i) - '0';
        }

        dp = new int[10][10][numarr.length];

        for(int[][] d1 : dp){
            for(int[] d2 : d1){
                Arrays.fill(d2, -1);
            }
        }

        int answer= 0;

        answer =dfs(4,6,0);

        return answer;


    }

    static int dfs(int left, int right, int idx){
        if(idx == numarr.length) return 0;
        if(dp[left][right][idx] != -1) return dp[left][right][idx];

        int target = numarr[idx];
        int leftCount = Integer.MAX_VALUE;
        int rightCount = Integer.MAX_VALUE;


        if(target != right){
            leftCount = getCount(left,target) + dfs(target, right, idx+1);
        }

        if(target != left){
            rightCount = getCount(right, target) + dfs(left, target, idx+1);
        }

        return dp[left][right][idx] = Math.min(leftCount, rightCount);
    }

    static int getCount(int a, int b){
        if(a == b) return 1;
        int[] a1 = pos[a];
        int[] b1 = pos[b];

        int dx = Math.abs(a1[0] - b1[0]);
        int dy = Math.abs(a1[1] - b1[1]);

        int daegak = Math.min(dx, dy);
        int straight = Math.max(dx, dy) - daegak;

        return 3 * daegak + 2 * straight;

    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";
        System.out.println(solution(numbers));
    }


}
