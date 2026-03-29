package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

/*
다익스트라 알고리즘 이용
 */

public class 특정거리의도시찾기 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        private int b;
        private int cost;

        public Edge(int b, int cost){
            this.b = b;
            this.cost = cost;
        }

        public int getB(){
            return this.b;

        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            if(this.cost == other.cost) return this.b - other.b;
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = 1;
            //단방향
            graph.get(a).add(new Edge(b, cost));
        }


        dijkstra(X);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dist.length;i++){
            if(dist[i] == K){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb.length() == 0 ? -1 : sb);

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getB();
            int dists = cur.getCost();
            if(dist[now] < dists) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i).getB();
                int cost = dist[now] + graph.get(now).get(i).getCost();
                if(dist[next] > cost){
                    dist[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }

    }

}
