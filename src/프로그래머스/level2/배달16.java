package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 배달16 {
    static ArrayList<Edge> edges;
    static int[] d;
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }

    public static int solution(int N, int[][] road, int K){
        int answer = 0;

        edges = new ArrayList<>();

        d = new int[N+1];
        Arrays.fill(d, INF);

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            edges.add(new Edge(a,b,cost));
            edges.add(new Edge(b,a,cost));

        }

        d[1] = 0;

        for(int i=0;i<N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }

        boolean negative = false;
        for(Edge e : edges){
            if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                negative = true;
            }
        }

        if(negative) System.out.println("음수 사이클 존재");

        for(int i=1;i<=N;i++){
            if(d[i] <= K){
                answer++;
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        System.out.println(solution(N, road, K));
    }

}
