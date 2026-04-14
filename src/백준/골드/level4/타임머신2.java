package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
최단경로 구할때 음수인 가중치 있으면
다익스트라 알고리즘보다는 벨만-포드 알고리즈 ㅁ이용
 */

public class 타임머신2 {
    static int N,M;
    //static int[] d;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;

    static class Edge{
        private int from;
        private int to;
        private int cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return this.from;
        }

        public int getTo(){
            return this.to;
        }

        public int getCost(){
            return this.cost;
        }



    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, cost));
        }

        long[] dist = bellmanFord(1);

        if(dist == null){
            System.out.println(-1);
        }else{
            for(int i=2;i<=N;i++){
                if(dist[i] == INF) System.out.println(-1);
                else System.out.println(dist[i]);
            }
        }




    }

    static long[] bellmanFord(int start){
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int i=1;i<N;i++){
            for(Edge e : edges){
                if(dist[e.getFrom()] != INF && dist[e.getTo()] > dist[e.getFrom()] + e.getCost()){
                    dist[e.getTo()] = dist[e.getFrom()] + e.getCost();
                }
            }
        }


        //음수 사이클 판별
        for(Edge e : edges){
            if(dist[e.getFrom()] != INF && dist[e.getTo()] > dist[e.getFrom()] + e.getCost()){
                return null;
            }
        }

        return dist;
    }

}
