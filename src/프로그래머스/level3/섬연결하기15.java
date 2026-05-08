package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
프림 알고리즘
 */

public class 섬연결하기15 {
    static ArrayList<ArrayList<Edge>> edges;
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
        int answer = 0;

        edges = new ArrayList<>();
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int cost2 = cost[2];

            edges.get(from).add(new Edge(to,cost2));
            edges.get(to).add(new Edge(from,cost2));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;
            if(visited[now]) continue;
            visited[now] = true;
            answer += cost;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost2 = edges.get(now).get(i).cost;
                if(!visited[next]){
                    pq.offer(new Edge(next, cost2));
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
