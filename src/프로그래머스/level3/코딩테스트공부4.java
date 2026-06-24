package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 코딩테스트공부4 {

    static ArrayList<ArrayList<Edge>> edges;
    static int[][] d;
    static int INF = (int) 1e9;
    static int maxalp;
    static int maxcop;

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
        edges = new ArrayList<>();
        maxalp = Integer.MIN_VALUE;
        maxcop = Integer.MIN_VALUE;
        for(int[] p : problems){
            maxalp = Math.max(maxalp, p[0]);
            maxcop = Math.max(maxcop, p[1]);
        }

        for(int i=0;i<=maxalp;i++){
            edges.add(new ArrayList<>());
        }

        alp = Math.min(alp, maxalp);
        cop = Math.min(cop, maxcop);

        d = new int[maxalp+1][maxcop+1];

        for(int i=0;i<=maxalp;i++){
            Arrays.fill(d[i], INF);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(alp, cop, 0));
        d[alp][cop] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int a = cur.alp;
            int c = cur.cop;
            int cost = cur.cost;

            if(d[a][c] < cost) continue;

            if(a + 1 <= maxalp){
                if(d[a+1][c] > cost + 1){
                    d[a+1][c] = cost + 1;
                    pq.offer(new Edge(a+1, c, cost+1));
                }
            }

            if(c + 1 <= maxcop){
                if(d[a][c+1] > cost + 1){
                    d[a][c+1] = cost + 1;
                    pq.offer(new Edge(a, c+1, cost + 1));
                }
            }


            for(int[] p : problems){
                int reqA = p[0];
                int reqC = p[1];
                int rA = p[2];
                int rC = p[3];
                int pCost = p[4];

                if(a >= reqA && c >= reqC){
                    int na = Math.min(maxalp, a + rA);
                    int nc = Math.min(maxcop, c + rC);

                    if(d[na][nc] > cost + pCost){
                        d[na][nc] = cost + pCost;
                        pq.offer(new Edge(na,nc,cost+pCost));
                    }

                }
            }

        }

        return d[maxalp][maxcop];
    }

    public static void main(String[] args) throws Exception{
        int alp = 0;
        int cop = 0;

        int[][] problems = {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};

        System.out.println(solution(alp, cop, problems));

    }

}
