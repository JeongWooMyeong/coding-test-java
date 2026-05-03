package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
다익스트라 알고리즘
정점기준
우선순위 큐 사용
 */

public class 배달8 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static int INF = Integer.MAX_VALUE;

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

    public static int solution(int N, int[][] road, int K){
        int answer = 0;
        edges = new ArrayList<>();
        d = new int[N+1];
        Arrays.fill(d, INF);

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
        //다익 스트라 알고리즘 시행
        dijkstra(1);

        for(int i=1;i<=N;i++){
            if(d[i] <= K){
                answer++;
            }
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
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        System.out.println(solution(N, road, K));
    }

}
