package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 파티2 {
    static int N, M, X; //학생 수 , 간선의 수, X 기준 방향
    static final int inf = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverseEdge = new ArrayList<>();

    static class Edge implements Comparable<Edge>{
        private int next;
        private int cost;

        public Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }

        private int getNext(){
            return this.next;
        }

        private int getCost(){
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
            edges.add(new ArrayList<Edge>());
            reverseEdge.add(new ArrayList<Edge>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(now).add(new Edge(next, cost));
            reverseEdge.get(next).add(new Edge(now, cost));
        }

        int[] getFromX = dijkstra(X, edges);  //X시작해서 다른 모든 노드
        int[] getToX = dijkstra(X, reverseEdge);    //X까지 최단거리 (reverse)

        int result = 0;
        for(int i=1;i<=N;i++){
            result = Math.max(result, getFromX[i] + getToX[i]);
        }

        System.out.println(result);


    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> graph){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d = new int[N+1];
        Arrays.fill(d, inf);

        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getNext();
            int dist = cur.getCost();

            if(d[now] < dist) continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getCost();
                int next = graph.get(now).get(i).getNext();

                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }

            }

        }
        return d;

    }

}
