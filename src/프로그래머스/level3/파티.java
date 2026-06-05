package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파티 {

    static int[] d;
    static ArrayList<ArrayList<Edge>> edges;
    static ArrayList<ArrayList<Edge>> reversed;
    static int INF = (int) 1e9;
    static int N,M,X;
    static int answer = Integer.MIN_VALUE;

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        reversed = new ArrayList<>();

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new Edge(to,cost));
            reversed.get(to).add(new Edge(from,cost));
        }

        int[] from = dijkstra(X, edges);
        int[] to = dijkstra(X, reversed);

        for(int i=1;i<=N;i++) {
            if(from[i] != INF && to[i] != INF) {
                answer = Math.max(answer, from[i] + to[i]);
            }
        }

        System.out.println(answer);


    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> edges){
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
