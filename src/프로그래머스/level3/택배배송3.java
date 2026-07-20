package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 택배배송3 {

    static ArrayList<Edge> edges;
    static int[] d;
    static int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }

    static int N,M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        edges = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,cost));
            edges.add(new Edge(b,a,cost));
        }

        d = new int[N+1];
        Arrays.fill(d, INF);
        d[1] = 0;
        for(int i=0;i<N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }

        boolean negative = false;
        for(Edge e : edges){
            if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                negative = true;
            }
        }

        if(negative) System.out.println("음수 발생");

       System.out.println(d[N]);
    }

}
