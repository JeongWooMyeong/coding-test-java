package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 코딩테스트공부7 {

    static int maxalp;
    static int maxcop;
    static int[][] dp;
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int alp;
        int cop;
        int cost;

        public Edge(int alp, int cop, int cost){
            this.alp = alp;
            this.cop = cop;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int alp, int cop, int[][] problems){
        maxalp = Integer.MIN_VALUE;
        maxcop = Integer.MIN_VALUE;

        for(int[] p : problems){
            maxalp = Math.max(maxalp, p[0]);
            maxcop = Math.max(maxcop, p[1]);
        }

        dp = new int[maxalp+1][maxcop+1];

        for(int[] d1 : dp){
           Arrays.fill(d1, INF);
        }

        alp = Math.min(alp, maxalp);
        cop = Math.min(cop, maxcop);
        dp[alp][cop] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(alp,cop,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int a = cur.alp;
            int c = cur.cop;
            int cost = cur.cost;

            if(dp[a][c] < cost) continue;

            if(a+1 <= maxalp){
                if(dp[a+1][c] > cost + 1){
                    dp[a+1][c] = cost +1;
                    pq.offer(new Edge(a+1,c,cost+1));
                }
            }

            if(c+1 <= maxcop){
                if(dp[a][c+1] > cost + 1){
                    dp[a][c+1] = cost +1;
                    pq.offer(new Edge(a, c+1, cost+1));
                }
            }

            for(int[] p : problems){
                int alp_req = p[0];
                int cop_req = p[1];
                int alp_rwd = p[2];
                int cop_rwd = p[3];
                int pcost = p[4];

                if(a >= alp_req && c >= cop_req){
                    int na = Math.min(a+alp_rwd, maxalp);
                    int nc = Math.min(c+cop_rwd, maxcop);

                    if(dp[na][nc] > cost + pcost){
                        dp[na][nc] = cost + pcost;
                        pq.offer(new Edge(na,nc,cost+pcost));
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
