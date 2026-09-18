package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 부대복귀7 {

    static List<List<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;
    static int[] answer;
    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++) edges.add(new ArrayList<>());

        for(int[] r : roads){
            int a = r[0];
            int b = r[1];

            edges.get(a).add(new Edge(b,1));
            edges.get(b).add(new Edge(a,1));
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        dijkstra(destination);


        answer = new int[sources.length];

        int idx = 0;
        for(int x : sources){
            if(d[x] == INF){
                answer[idx++] = -1;
            }else {
                answer[idx++] = d[x];
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
        int n = 3;
        int[][] roads = {{1,2},{2,3}};
        int[] sources = {2,3};
        int destination = 1;

        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }

}
