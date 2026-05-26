package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자타자대회 {

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

    public static int solution(String numbers){
        numarr = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            numarr[i] = numbers.charAt(i) - '0';
        }

        dp = new int[10][10][numarr.length];   //왼손, 오른손, idx

        for(int[][] d : dp){
            for(int[] d2 : d){
                Arrays.fill(d2, -1);
            }
        }

        int answer = 0;
        answer = dfs(4,6,0);

        return answer;

    }

    static int dfs(int left, int right, int idx){
        if(idx == numarr.length) return 0;  //다다르면 가중치 값 변경 X
        if(dp[left][right][idx] != -1) return dp[left][right][idx];

        int target = numarr[idx];

        int leftCount = Integer.MAX_VALUE;
        int rightCount = Integer.MAX_VALUE;
        //왼손 쓸 경우
        if(target != right) {
            leftCount = getScore(left, target) + dfs(target, right, idx + 1);
        }
        //오른손 쓸 경우
        if(target != left) {
            rightCount = getScore(right, target) + dfs(left, target, idx + 1);
        }
        return dp[left][right][idx] = Math.min(leftCount, rightCount);
    }

    static int getScore(int from, int to){
        if(from == to) return 1;
        int[] f = pos[from];
        int[] t = pos[to];

        int dx = Math.abs(f[0] - t[0]);
        int dy = Math.abs(f[1] - t[1]);
        //뭔말인지 모르겠음 -> 이해함
        int diagonal = Math.min(dx, dy);
        int straight = Math.max(dx, dy) - diagonal;

        return diagonal * 3 + straight * 2;

    }

    public static void main(String[] args) throws Exception{
        String numbers = "1756";
        System.out.println(solution(numbers));
    }

}
