package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
다익스트라 알고리즘
 */

public class 가장먼노드6 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;

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

    public static int solution(int n, int[][] edge){
        int answer = 0;
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int[] e : edge){
            int from = e[0];
            int to = e[1];
            int cost = 1;

            edges.get(from).add(new Edge(to, cost));
            edges.get(to).add(new Edge(from, cost));
        }

        dijkstra(1);

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max = Math.max(max, d[i]);
        }

        for(int i=1;i<=n;i++){
            if(d[i] == max) answer++;
        }

        return answer;
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
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

    }

    public static void main(String[] args) throws Exception{
        int n  = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(n, vertex));
    }

}
