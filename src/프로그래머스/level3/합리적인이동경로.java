package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 합리적인이동경로 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] dist;
    static int INF = (int) 1e9;
    static int[] dp;
    static int N,M;

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
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new Edge(to,cost));
            edges.get(to).add(new Edge(from,cost));
        }
        //아 목적지에서 거리를 구해야 정점부터 2번까지의 최단거리가 되는구나..
        int start = 2;
        dijkstra(start);

        dp = new int[N+1];
        Arrays.fill(dp, -1);
        int answer = dfs(1);

        System.out.println(answer);
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dists = cur.cost;
            if(dist[now] < dists) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next =edges.get(now).get(i).to;
                int cost = dist[now] + edges.get(now).get(i).cost;
                if(dist[next] > cost){
                    dist[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }

    }

    static int dfs(int now){
        if(now == 2) return 1;
        if(dp[now] != -1) return dp[now];

        dp[now] = 0;
        for(Edge e : edges.get(now)){
            if(dist[now] > dist[e.to]){
                dp[now] += dfs(e.to);
            }
        }

        return dp[now];

    }

}
