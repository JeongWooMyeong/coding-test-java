package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class LCA5 {

    static int N,M,LOG;
    static int[][] parent;
    static int[] depth;
    static int[] dist;
    static boolean[] visited;
    static List<List<Integer>> edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());
        LOG = 1;

        while((1<<LOG) < N){
            LOG++;
        }

        parent = new int[LOG][N+1];
        depth = new int[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);

        }

        dfs(1,0,0,0);

        for(int k=1;k<LOG;k++){
            for(int v=1;v<=N;v++){
                parent[k][v] = parent[k-1][parent[k-1][v]];
            }
        }

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a,b)).append("\n");
        }

        System.out.print(sb);


    }

    static void dfs(int v, int p, int d, int c){
        parent[0][v] = p;
        depth[v] = d;
        dist[v] = c;
        visited[v] = true;

        for(int i=0;i<edges.get(v).size();i++){
            int next = edges.get(v).get(i);
            if(!visited[next]){
                dfs(next,v,d+1,c+1);
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
