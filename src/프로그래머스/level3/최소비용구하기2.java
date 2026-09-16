package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최소비용구하기2 {

    static int N,M;
    static List<Edge> edges;
    static int[] d;
    static int INF = (int) 1e9;
    static class Edge implements Comparable<Edge>{
        int from,to,cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();

        d = new int[N+1];
        Arrays.fill(d, INF);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,cost));

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        d[start] = 0;
        for(int i=0;i<N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }

        boolean negative = false;
        for(int i=0;i<N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    negative = true;
                }
            }
        }

        if(negative) System.out.println("음수 발생");

        System.out.println(d[end]);

    }

}
