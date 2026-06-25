package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회4 {

    static int[][][] dp;
    static int[] numarr;
    static int[][] pos ={
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
    static int answer = 0;

    public static int solution(String numbers){
        dp = new int[10][10][numbers.length()];
        numarr = new int[numbers.length()];

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
            leftCount = getCount(left, target) + dfs(target, right,idx+1);
        }

        if(left != target){
            rightCount = getCount(right, target) + dfs(left, target, idx+1);
        }

        return dp[left][right][idx] = Math.min(leftCount, rightCount);
    }

    static int getCount(int a, int b){
        //이동하지 않았을때 제자리 다시 누르는거 포함 가중치 1
        if(a == b) return 1;
        int[] p1 = pos[a];
        int[] p2 = pos[b];

        int dx = Math.abs(p2[0] - p1[0]);
        int dy = Math.abs(p2[1] - p1[1]);

        int daegak = Math.min(dx,dy);
        int straight = Math.max(dx,dy) - daegak;

        return 3 * daegak + 2 * straight;
    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";
        System.out.println(solution(numbers));
    }

}
