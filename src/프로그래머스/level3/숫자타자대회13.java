package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회13 {

    static int n;
    static int[][][] dp;
    static int[] numarr;
    static int answer;
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

        answer = dfs(4, 6, 0);

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
            rightCount = getCount(right, target) + dfs(left, target, idx+1);
        }

        return dp[left][right][idx] = Math.min(leftCount, rightCount);

    }

    static int getCount(int left, int right){
        if(left == right) return 1; //제자리
        int[] a = pos[left];
        int[] b = pos[right];

        int dx = Math.abs(a[0] - b[0]);
        int dy = Math.abs(a[1] - b[1]);

        int daegak = Math.min(dx, dy);
        int straight = Math.max(dx,dy) - daegak;

        return 3 * daegak + 2 * straight;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";

        System.out.println(solution(numbers));
    }

}
