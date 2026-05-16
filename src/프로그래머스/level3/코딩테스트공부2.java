package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 코딩테스트공부2 {
    static int[][] dp;

    public static int solution(int alp, int cop, int[][] problems){
        int answer = 0;
        int maxalp = Integer.MIN_VALUE;
        int maxcop = Integer.MIN_VALUE;

        for(int[] p : problems){
            maxalp = Math.max(maxalp, p[0]);
            maxcop = Math.max(maxcop, p[1]);
        }
        dp = new int[maxalp+1][maxcop+1];

        //혹시 기존 alp,cop 보다 max가 낮을 수 있으므로 확인
        alp = Math.min(alp, maxalp);
        cop = Math.min(cop, maxcop);

        //DP 초기화
        int INF = (int) 1e9;
        for(int i=0;i<=maxalp;i++){
            Arrays.fill(dp[i], INF);
        }

        dp[alp][cop] = 0;

        for(int a=alp;a<=maxalp;a++){
            for(int c=cop;c<=maxcop;c++){
                //알고력 올리기
                if(a+1 <= maxalp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                }
                //코딩력 올리기
                if(c+1 <= maxcop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                }
                //문제풀기
                for(int[] p : problems){
                    int alp_req = p[0];
                    int cop_req = p[1];
                    int alp_rwd = p[2];
                    int cop_rwd = p[3];
                    int cost = p[4];

                    if(a >= alp_req && c >= cop_req){
                        int na = Math.min(a+alp_rwd, maxalp);
                        int nc = Math.min(c+cop_rwd, maxcop);

                        dp[na][nc] = Math.min(dp[na][nc], dp[a][c] + cost);
                    }

                }
            }
        }


        return dp[maxalp][maxcop];
    }

    public static void main(String[] args) throws Exception{
        int alp = 0;
        int cop = 0;

        int[][] problems = {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};

        System.out.println(solution(alp, cop, problems));

    }

}
