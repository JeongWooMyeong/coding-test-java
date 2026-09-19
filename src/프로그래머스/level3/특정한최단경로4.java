package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 특정한최단경로4 {

    static int N,E;
    static List<List<Edge>> edges;
    static long[] d;
    static long INF = Long.MAX_VALUE;
    static class Edge implements Comparable<Edge>{
        int to;
        long cost;

        public Edge(int to, long cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Long.compare(this.cost, other.cost);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long[] dist1 = dijkstra(1);
        long[] distv1 = dijkstra(v1);
        long[] distv2 = dijkstra(v2);

        long answer = INF;

        long value1 = dist1[v1] + distv1[v2] + distv2[N];
        long value2 = dist1[v2] + distv2[v1] + distv1[N];

        answer = Math.min(value1, value2);

        if(answer >= INF) answer = -1;

        System.out.println(answer);
    }

    static long[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new long[N+1];
        Arrays.fill(d, INF);

        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            long dist = cur.cost;

            if(d[now] < dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                long cost = d[now] + edges.get(now).get(i).cost;

                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next,cost));
                }
            }

        }

        return d;
    }

}
