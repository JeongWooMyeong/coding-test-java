package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 코딩테스트공부11 {

    static int maxalp;
    static int maxcop;
    static int[][] dp;
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
            return Integer.compare(this.cost, other.cost);
        }

    }

    public static int solution(int alp, int cop, int[][] problems){
        maxalp = Integer.MIN_VALUE;
        maxcop = Integer.MIN_VALUE;

        for(int[] p : problems){
            maxalp = Math.max(maxalp, p[0]);
            maxcop = Math.max(maxcop, p[1]);
        }

        alp = Math.min(alp, maxalp);
        cop = Math.min(cop, maxcop);

        dp = new int[maxalp+1][maxcop+1];

        for(int i=0;i<=maxalp;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(alp,cop,0));
        dp[alp][cop] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            int al = cur.alp;
            int co = cur.cop;
            int cost = cur.cost;

            if(dp[al][co] < cost) continue;


            if(al+1 <= maxalp && dp[al+1][co] > cost + 1){
                dp[al+1][co] = cost + 1;
                pq.offer(new Edge(al+1,co,cost+1));
            }

            if(co+1 <= maxcop && dp[al][co+1] > cost + 1){
                dp[al][co+1] = cost + 1;
                pq.offer(new Edge(al,co+1,cost+1));
            }

            for(int[] p : problems){
                int alp_req = p[0];
                int cop_req = p[1];
                int alp_rwd = p[2];
                int cop_rwd = p[3];
                int newcost = cost + p[4];

                if(al >= alp_req && co >= cop_req){
                    int newalp = Math.min(maxalp, al+alp_rwd);
                    int newcop = Math.min(maxcop, co+cop_rwd);
                    if(dp[newalp][newcop] > newcost){
                        dp[newalp][newcop] = newcost;
                        pq.offer(new Edge(newalp, newcop, newcost));
                    }
                }

            }

        }

        return dp[maxalp][maxcop];
    }

    public static void main(String[] args) throws Exception{
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};
        System.out.println(solution(alp,cop,problems));
    }

}
