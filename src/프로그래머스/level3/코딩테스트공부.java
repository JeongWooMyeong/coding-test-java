package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 코딩테스트공부 {

    public static int solution(int alp, int cop, int[][] problems){
        int maxAlp = Integer.MIN_VALUE;
        int maxCop = Integer.MIN_VALUE;
        //maxAlp, maxCop 구하기
        for(int[] p : problems){
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        //maxAlp를 넘을 수도 있으니 확인 필요
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        //알고, 코딩력 올리는데 걸리는 시간 dp
        int[][] dp = new int[maxAlp+1][maxCop+1];
        int INF = (int)1e9;

        for(int i=0;i<=maxAlp;i++){
            Arrays.fill(dp[i], INF);
        }

        dp[alp][cop] = 0;

        for(int a=alp;a<=maxAlp;a++){
            for(int c=cop;c<=maxCop;c++){
                //1. 알고력 올리기
                if(a+1 <= maxAlp){
                    dp[a+1][c] = Math.min(dp[a+1][c], dp[a][c] + 1);
                }

                //2. 코딩력 올리기
                if(c+1 <= maxCop){
                    dp[a][c+1] = Math.min(dp[a][c+1], dp[a][c] + 1);
                }

                //3. 문제풀기
                for(int[] p : problems){
                    int alp_req = p[0];
                    int cop_req = p[1];
                    int alp_rwd = p[2];
                    int cop_rwd = p[3];
                    int cost = p[4];
                    //a가 요구 알고력 이상 이고 c가 요구 코딩력 이상이면
                    if(a >= alp_req && c >= cop_req) {
                        int na = Math.min(maxAlp, a + alp_rwd);
                        int nc = Math.min(maxCop, c + cop_rwd);

                        dp[na][nc] = Math.min(dp[na][nc], dp[a][c] + cost);
                    }

                }

            }
        }

        return dp[maxAlp][maxCop];
    }

    public static void main(String[] args) throws Exception{
        int alp = 10;
        int cop = 10;

        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};

        System.out.println(solution(alp,cop,problems));

    }

}
