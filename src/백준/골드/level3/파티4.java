package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 파티4 {
    static int N, M, X;
    static int[] d;
    static int INF = (int) 1e9;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverse = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    static class Edge implements Comparable<Edge>{
        int next;
        int cost;

        public Edge(int next, int cost){
            this.next = next;
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

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new Edge(to, cost));
            reverse.get(to).add(new Edge(from, cost));
        }

        int[] from = dijkstra(X, edges);
        int[] to = dijkstra(X, reverse);

        for(int i=1;i<=N;i++){
            result = Math.max(from[i] + to[i], result);
        }

        System.out.println(result);

    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> list){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d= new int[N+1];
        Arrays.fill(d, INF);
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.next;
            int dist = cur.cost;
            if(d[now] < dist) continue;
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i).next;
                int cost = d[now] + list.get(now).get(i).cost;
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }

        return d;

    }



}
