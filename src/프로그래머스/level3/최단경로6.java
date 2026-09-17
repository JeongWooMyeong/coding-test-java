package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최단경로6 {

    static int V,E,K;
    static List<List<Edge>> edges;
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

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
        }
        d = new int[V+1];
        Arrays.fill(d, INF);

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=V;i++){
            if(i == K){
                sb.append(0);
            }else if(d[i] == INF){
                sb.append("INF");
            }else{
                sb.append(d[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Edge(start, 0));

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
    }

}
