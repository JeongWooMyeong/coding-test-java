package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
6번 돌려야 해서 비효율적
 */

public class 특정한최단경로 {

    static int N,E;
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;
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
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

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

        long d1 = (dijkstra(1,v1) == -1 || dijkstra(v1,v2) == -1 || dijkstra(v2,N) == -1) ? INF :
                dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,N);
        long d2 = (dijkstra(1,v2) == -1 || dijkstra(v2,v1) == -1 || dijkstra(v1,N) == -1) ? INF :
                dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,N);

        long answer = Math.min(d1, d2);

        if(answer >= INF) System.out.println(-1);
        else System.out.println(answer);

    }

    static int dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[N+1];
        Arrays.fill(d, INF);
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(now == end) return dist;
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

        return -1;

    }

}
