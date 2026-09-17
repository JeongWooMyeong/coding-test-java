package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 특정한최단경로3 {

    static int N,E;
    static int v1,v2;
    static List<List<Edge>> edges;
    static long answer;
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
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distv1 = dijkstra(v1);
        int[] distv2 = dijkstra(v2);

        long value1 = dist1[v1] + distv1[v2] + distv2[N];
        long value2 = dist1[v2] + distv2[v1] + distv1[N];

        answer = Math.min(value1, value2);

        if(answer >= INF) answer = -1;

        System.out.println(answer);
    }

    static int[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[N+1];
        Arrays.fill(d, INF);
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
