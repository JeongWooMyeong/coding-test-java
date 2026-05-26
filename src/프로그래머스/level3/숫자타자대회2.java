package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회2 {
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

    static int[][][] dp;
    static int n;

    public static int solution(String numbers){
        n = numbers.length();
        numarr = new int[n];
        for(int i=0;i<n;i++){
            numarr[i] = numbers.charAt(i) - '0';
        }

        dp = new int[10][10][numarr.length];
        //dp 초기화
        for(int[][] d : dp){
            for(int[] d2 : d){
                Arrays.fill(d2, -1);
            }
        }

        //왼쪽4 오른쪽 6에서 시작
        return dfs(4,6,0);

    }

    static int dfs(int left, int right, int idx){
        if(idx == numarr.length) return 0;
        if(dp[left][right][idx] != -1) return dp[left][right][idx];

        int target = numarr[idx];
        int leftCount = Integer.MAX_VALUE;
        int rightCount = Integer.MAX_VALUE;

        //왼손으로 찾는 경우 -> 오른손에 target값 있으면 안됌
        if(target != right){
            leftCount = getCount(left, target) + dfs(target, right, idx+1);
        }

        if(target != left){
            rightCount = getCount(right, target) + dfs(left, target, idx+1);
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
