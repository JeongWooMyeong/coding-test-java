package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 최단경로5 {
    static int V,E;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] d;
    static int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge>{
        private int next;
        private int cost;

        public Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }

        public int getNext(){
            return this.next;
        }

        public int getCost(){
            return this.cost;
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

        d = new int[V+1];
        Arrays.fill(d, INF);

        int start = Integer.parseInt(br.readLine());

        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, cost));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            if(d[i] == INF) sb.append("INF").append("\n");
            else sb.append(d[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getNext();
            int dist = cur.getCost();
            if(d[now] < dist) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).getNext();
                int cost = d[now] + edges.get(now).get(i).getCost();

                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }
    }

}
