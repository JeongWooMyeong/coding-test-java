package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 특정한최단경로2 {
    static int N,E;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] d;
    static int[] distFrom1;
    static int[] distFromV1;
    static int[] distFromV2;
    static int INF = (int)1e9;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distFrom1 = new int[N+1];
        distFromV1 = new int[N+1];
        distFromV2 = new int[N+1];

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        distFrom1 = dijkstra(1);
        distFromV1 = dijkstra(v1);
        distFromV2 = dijkstra(v2);

        int dist1 = distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        int dist2 = distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        int result = 0;
        result = Math.min(dist1, dist2);

        System.out.print(result);


    }

    static int[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d= new int[N+1];
        Arrays.fill(d, INF);
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
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }

            }
        }

        return d;

    }

}
