package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 최단경로 {
    static int INF = (int) 1e9;
    static int v, e, start;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] d;

    static class Edge implements Comparable<Edge>{
        //private int a;
        private int b;
        private int cost;

        public Edge( int b, int cost){
            //this.a = a;
            this.b = b;
            this.cost = cost;
        }

//        public int getA(){
//            return this.a;
//        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
        }
        //가중치 오름차순으로 정렬
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
        Arrays.fill(d, INF);
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<Edge>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

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
        //우선순위 큐 설정
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //시작노드 넣는다
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int dist = edge.getCost();
            int now = edge.getB();

            if(d[now] < dist) continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getCost();
                if(cost < d[graph.get(now).get(i).getB()]){
                    d[graph.get(now).get(i).getB()] = cost;
                    pq.offer(new Edge(graph.get(now).get(i).getB(), cost));
                }
            }

        }

    }
}
