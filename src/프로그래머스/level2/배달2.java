package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 배달2 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static final int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int next,cost;

        public Edge(int next, int cost){
            this.next = next;
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

        for(int i=0;i<road.length;i++){
            int[] info = road[i];

            int a = info[0];
            int b = info[1];
            int cost = info[2];

            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));

        }

        dijkstra(1);

        for(int i=1;i<=N;i++){
            if(d[i] != INF && d[i] <= K){
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
            int now = cur.next;
            int dist = cur.cost;
            if(d[now] < dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).next;
                int cost = d[now] + edges.get(now).get(i).cost;;

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
