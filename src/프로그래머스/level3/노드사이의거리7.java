package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 노드사이의거리7 {

    static int N,M,LOG;
    static ArrayList<ArrayList<Edge>> edges;
    static int[] depth;
    static int[] dist;
    static int[][] parent;
    static StringBuilder sb;

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LOG = 1;

        while((1 << LOG) < N){
            LOG++;
        }

        depth = new int[N+1];
        dist = new int[N+1];
        parent = new int[LOG][N+1];
        sb = new StringBuilder();

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        dfs(1, 0, 0, 0);

        //parent 채우기
        for(int k=1;k<LOG;k++){
            for(int v=1;v<=N;v++){
                parent[k][v] = parent[k-1][parent[k-1][v]];
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int lca = LCA(start, end);
            int distance = dist[start] + dist[end] - 2 * dist[lca];
            sb.append(distance).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void dfs(int v, int p, int d, int cost){
        parent[0][v] = p;
        depth[v] = d;
        dist[v] = cost;

        for(int i=0;i<edges.get(v).size();i++){
            int next = edges.get(v).get(i).to;
            int cost2 = edges.get(v).get(i).cost;

            if(next != p){
                dfs(next, v, d+1, cost + cost2);
            }


        }

    }

    static int LCA(int u, int v){
        if(depth[u] < depth[v]){
            int tmp = v;
            v = u;
            u = tmp;
        }

        for(int k=LOG-1;k>=0;k--){
            if(depth[u] - (1<<k) >= depth[v]){
                u = parent[k][u];
            }
        }

        if(u == v) return u;

        for(int k=LOG-1;k>=0;k--){
            if(parent[k][u] != parent[k][v]){
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }

}
