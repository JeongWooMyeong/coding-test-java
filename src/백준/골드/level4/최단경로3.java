package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 최단경로3 {
    static int V,E;
    static int[] d; //최단거리
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;
    static int start;

    static class Edge implements Comparable<Edge>{

        private int b;
        private int cost;

        public Edge(int b, int cost){
            //this.a = a;
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
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        d = new int[V+1];
        Arrays.fill(d, INF);

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
        for(int i=1;i<d.length;i++){
            if(INF == d[i]){
                sb.append("INF").append("\n");
            }else {
                sb.append(d[i] ).append("\n");
            }
        }

        System.out.print(sb);

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getB();
            int dist = cur.getCost();
            if(d[now] < dist) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).getB();
                int cost = d[now] + edges.get(now).get(i).getCost();

                if(d[next] > cost){
                    pq.offer(new Edge(next, cost));
                    d[next] = cost;
                }

            }
        }
    }

}
