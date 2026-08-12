package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파티3 {

    static int N,M,X;
    static ArrayList<ArrayList<Edge>> edges;
    static ArrayList<ArrayList<Edge>> reversed;
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            reversed.get(b).add(new Edge(a,cost));
        }

        int[] from = dijkstra(X, edges);
        int[] to = dijkstra(X, reversed);

        int answer = Integer.MIN_VALUE;

        for(int i=1;i<=N;i++){
            answer = Math.max(answer, from[i] + to[i]);
        }

        System.out.println(answer);

    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> list){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[N+1];
        Arrays.fill(d, INF);
        pq.offer(new Edge(start,0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(d[now] < dist) continue;

            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i).to;
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
