package 이것이코딩테스트다2.기출문제.최단경로;

import java.util.*;
import java.io.*;

/*
인접리스트로 다익스트라 구하는건 이 문제에서는 틀림
이문제에서는 grid로 주어졌기 때문에 간선에 대한 정보는 주어져 있지 않음
그래서 다르게 접근해야함..
XXXXXXXXXXXXXXXXXXXXXXXXXXX

 */

public class 화성탐사 {
    static int T, N;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] d;
    static final int INF = (int) 1e9;

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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            d = new int[N+1];

            Arrays.fill(d, INF);
            for(int i=0;i<=N;i++){
                graph.add(new ArrayList<>());
            }

            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=N;j++){
                    int cost = Integer.parseInt(st.nextToken());
                    graph.get(i).add(new Edge(j, cost));
                }
            }

            dijkstra(1);

            System.out.println(d[N]);

        }
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge starts = graph.get(start).get(start);
        pq.offer(new Edge(start, starts.getCost()));
        d[start] = starts.getCost();

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getB();
            int dist = cur.getCost();
            if(d[now] > dist) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i).getB();
                int cost = d[now] + graph.get(now).get(i).getCost();
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }

            }

        }

    }

}
