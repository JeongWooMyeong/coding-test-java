package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
LCA (최소 공통 조상) - 두 노드에서 가장 가까운 노드 찾기
 */

public class 노드사이의거리4 {

    static int N, M, LOG;
    static ArrayList<ArrayList<Edge>> edges;
    static int[][] parent;  //parent[k][v] = v의 2^k번째 조상
    static int[] depth;
    static int[] dist;

    static class Edge{
        int to, cost;
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
        while((1 << LOG) <= N) LOG++;

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());

        //트리 입력
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        parent = new int[LOG][N+1];
        depth = new int[N+1];
        dist = new int[N+1];

        //루트 (1번노드) 기준 DFS
        dfs(1, 0, 0, 0);

        //parent 테이블 채우기 2칸위
        for(int k=1;k<LOG;k++){
            for(int v=1;v<=N;v++){
                parent[k][v] = parent[k-1][parent[k-1][v]];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int lca = LCA(u, v);
            int distance = dist[u] + dist[v] - 2 * dist[lca];
            sb.append(distance).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void dfs(int v, int p, int d, int c){
        parent[0][v] = p;
        depth[v] = d;
        dist[v] = c;
        for(Edge e : edges.get(v)){
            if(e.to != p){
                dfs(e.to, v, d+1, c+e.cost);
            }
        }
    }

    static int LCA(int u, int v){
        if(depth[u] < depth[v]){
            int tmp = u;
            u = v;
            v = tmp;
        }
        //깊이 맞추기
        for(int k=LOG-1;k>=0;k--){
            if(depth[u] - (1 << k) >= depth[v]){
                u = parent[k][u];
            }
        }

        if(u == v) return u;
        //동시에 올리기
        for(int k=LOG-1;k>=0;k--){
            if(parent[k][u] != parent[k][v]){
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];

    }

}
