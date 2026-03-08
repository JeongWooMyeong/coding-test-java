package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 최단경로2 {
    static final int INF = (int) 1e9;
    static int v, e, start;
    static int[] d; //최단거리 테이블
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static class Edge implements Comparable<Edge>{
        private int b;
        private int cost;

        public Edge(int b, int  cost){
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        d = new int[v+1];
        Arrays.fill(d, INF);    //최단거리 테이블 무한으로 초기화

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<Edge>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //방향 그래프
            graph.get(a).add(new Edge(b, cost));

        }

        dijkstra(start);

        for(int i=1;i<=v;i++){
            if(d[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(d[i]);
            }
        }

    }

    public static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;
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
