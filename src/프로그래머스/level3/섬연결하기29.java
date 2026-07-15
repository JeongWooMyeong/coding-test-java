package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
프림 알고리즘
 */

public class 섬연결하기29 {

    static ArrayList<ArrayList<Edge>> edges;
    static int answer;
    static int[] d;
    static int INF = (int) 1e9;
    static boolean[] visited;

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

    public static int solution(int n, int[][] costs){

        answer = 0;
        edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        d = new int[n];
        visited = new boolean[n];
        Arrays.fill(d, INF);

        for(int[] c : costs){
            int a = c[0];
            int b = c[1];
            int cost = c[2];

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0));
        d[0] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(d[now] < dist) continue;
            if(visited[now]) continue;
            visited[now] = true;
            answer += dist;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;

                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }

            }

        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n, costs));
    }

}
