package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
모든 섬을 최소비용으로 연결
이번에는 프림 알고리즘 - 정점 기준
 */

public class 섬연결하기2 {
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static boolean[] visited;

    static class Edge{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    public static int solution(int n, int[][] costs){
        int answer = 0;

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int pay = cost[2];

            edges.get(a).add(new Edge(b, pay));
            edges.get(b).add(new Edge(a, pay));
        }

        visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        pq.offer(new Edge(0, 0));
        //visited[0] = true;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int to = cur.to;
            int cost = cur.cost;
            if(visited[to]) continue;
            //꺼낼때 visited 체크
            visited[to] = true;
            answer += cost;

            for(int i=0;i<edges.get(to).size();i++){
                int next = edges.get(to).get(i).to;
                int ncost = edges.get(to).get(i).cost;
                if(!visited[next]){
                    pq.offer(new Edge(next, ncost));
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
