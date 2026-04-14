package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 웜홀 {
    static int TC;
    static int N,M,W;
    static ArrayList<Edge> edges;
    static int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    static class Edge{
        int from;
        int to;
        int cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //테스트 케이스
        TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){
            edges = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            //도로의 정보
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(a,b,cost));
                edges.add(new Edge(b,a,cost));
            }

            //웜홀의 정보
            for(int i=0;i<W;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(a,b,-cost));
            }

            sb.append(bellmanFord() ? "YES" : "NO").append("\n");

        }

        System.out.println(sb.toString());
    }

    static boolean bellmanFord(){
        long[] dist = new long[N+1];
        Arrays.fill(dist, 0);   //모든 정점에서 시작가능하게 0에서 시작

        for(int i=1;i<N;i++){
            for(Edge e : edges){
                if(dist[e.to] > dist[e.from] + e.cost){
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        for(Edge e : edges){
            if(dist[e.to] > dist[e.from] + e.cost){
                return true;
            }
        }

        return false;
    }

}
