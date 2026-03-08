package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 최소비용구하기 {
    static int v, e, start, end;
    static int[] d; //최단거리 테이블
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static final int INF = (int) 1e9;   //거리 무한

    static class Edge implements Comparable<Edge>{
        private int b;
        private int cost;

        public Edge(int b, int cost){
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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        d = new int[v+1];
        Arrays.fill(d, INF);

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<Edge>());
        }

        for(int i=0;i<e;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        dijkstra(start);


        System.out.println(d[end]);

    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.getB();
            int dist = edge.getCost();
            if(d[now] < dist) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getCost();
                int next = graph.get(now).get(i).getB();

                if(cost < d[next]){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }

    }

}
