package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 노드사이의거리 {

    static int N,M;
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
            return Integer.compare(this.cost, other.cost);
        }

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            d = new int[N+1];
            Arrays.fill(d, INF);

            int[] dist = dijkstra(start);

            sb.append(dist[end]).append("\n");
        }

        System.out.println(sb.toString());



    }

    static int[] dijkstra(int start){
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

        return d;
    }

}
