package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
다익스트라 알고리즘 활용
 */

public class 배달12 {
    static ArrayList<ArrayList<Edge>> edges;
    static int INF = (int) 1e9;
    static int[] d;
    static int n;

    static class Edge implements Comparable<Edge>{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }


    public static int solution(int N, int[][] road, int K){
        int answer = 0;
        n = N;
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));

        }

        dijkstra(1);

        for(int i=1;i<=N;i++){
            if(d[i] <= K) answer++;
        }

        return answer;

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d = new int[n+1];
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
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        System.out.println(solution(N, road, K));
    }


}
