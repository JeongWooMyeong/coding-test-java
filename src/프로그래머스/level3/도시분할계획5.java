package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 도시분할계획5 {

    static int N, M;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[] visited;
    static int[] d;
    static int INF = (int) 1e9;
    static int answer;
    static int maxCost;

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
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

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        answer = 0;
        maxCost = Integer.MIN_VALUE;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        visited = new boolean[N+1];
        d = new int[N+1];
        Arrays.fill(d, INF);
        d[1] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(visited[now]) continue;
            visited[now] = true;
            answer += dist;
            maxCost = Math.max(maxCost, dist);

            for(Edge e : edges.get(now)){
                int next = e.to;
                int cost = e.cost;

                if(!visited[next] && d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next,cost));
                }

            }

        }

        System.out.println(answer - maxCost);
    }

}
