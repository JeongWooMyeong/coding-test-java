package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 택시합승요금9 {
    static int INF = (int) 1e9;
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static long answer = Long.MAX_VALUE;
    static int n1;

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }


    public static int solution(int n, int s, int a, int b, int[][] fares){
        edges = new ArrayList<>();
        n1 = n;

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] f : fares){
            int from = f[0];
            int to = f[1];
            int cost = f[2];

            edges.get(from).add(new Edge(to,cost));
            edges.get(to).add(new Edge(from, cost));
        }

        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        int[] distS = dijkstra(s);

        for(int k=1;k<=n;k++){
            if(distA[k] != INF && distB[k] != INF && distS[k] != INF){
                answer = Math.min(answer, (long)distS[k] + distA[k] + distB[k]);
            }
        }

        return (int) answer;
    }

    static int[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d = new int[n1+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(d[now] < dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = d[now] + edges.get(now).get(i).cost;
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }

        }

        return d;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};

        System.out.println(solution(n,s,a,b,fares));
    }

}
