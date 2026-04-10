package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 파티3 {
    static int N,M,X;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverseEdges = new ArrayList<>();

    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int next;
        int cost;

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
            reverseEdges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, cost));
            reverseEdges.get(b).add(new Edge(a, cost));

        }

        int[] from = dijkstra(X, edges);
        int[] to = dijkstra(X, reverseEdges);

        int result = Integer.MIN_VALUE;

        for(int i=1;i<=N;i++){
           result = Math.max(from[i] + to[i], result);
        }

        System.out.print(result);



    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> edges){
        int[] d = new int[N+1];
        Arrays.fill(d, INF);
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


        return d;


    }


}
