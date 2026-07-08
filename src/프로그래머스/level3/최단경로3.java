package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최단경로3 {

    static int V,E;
    static ArrayList<Edge> edges;
    static int[] d;
    static int INF = Integer.MAX_VALUE;
    static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost){
            this.from = from;
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

        edges = new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        d = new int[V+1];
        Arrays.fill(d, INF);

        d[start] = 0;
        for(int i=0;i<V-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }


        boolean negative = false;
        for(Edge e : edges){
            if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                negative = true;
            }
        }

        if(negative) System.out.println("음수 가중치 존재");


        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            if(d[i] == INF){
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(d[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

}
