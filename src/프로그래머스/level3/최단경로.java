package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최단경로 {
    static ArrayList<ArrayList<Edge>> edges;
    static int INF = (int) 1e9;
    static int[] d;
    static int V,E;

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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        d = new int[V+1];
        Arrays.fill(d, INF);

        edges = new ArrayList<>();
        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //문제에서 방향 그래프
            edges.get(a).add(new Edge(b,cost));
            //edges.get(b).add(new Edge(a,cost));
        }

        dijkstra(start);


        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            if(d[i] == INF){
                sb.append("INF").append("\n");
            }else {
                sb.append(d[i]).append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(d[now] > dist) continue;
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

}
