package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 배달 {
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] d;
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int next;
        int cost;

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
        d = new int[N+1];
        Arrays.fill(d, INF);

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<road.length;i++){
            int[] input = road[i];
            int a = input[0];
            int b = input[1];
            int cost = input[2];

            //양방향
            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));
        }

        answer = dijkstra(1, K);


        return answer;
    }

    static int dijkstra(int start, int K){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;
        int count = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.next;
            int dist = cur.cost;
            if(d[now] < dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).next;
                int cost = d[now] + edges.get(now).get(i).cost;
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }

            }


        }
        //최단거리 구한거중에서 K이하인 최단거리 구해서 count
        for(int x : d){
            if(x <= K){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        System.out.println(solution(N, road, K));
    }

}
