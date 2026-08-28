package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class LCA8 {

    static int N,M,LOG;
    static int[][] parent;
    static int[] depth;
    static StringBuilder sb;
    static List<List<Integer>> edges;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        LOG = 1;
        while((1<<LOG) < N){
            LOG++;
        }

        parent = new int[LOG][N+1];
        depth = new int[N+1];

        sb = new StringBuilder();
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);

        }

        bfs(1);

        for(int k=1;k<LOG;k++){
            for(int v=1;v<=N;v++){
                parent[k][v] = parent[k-1][parent[k-1][v]];
            }
        }

        M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(LCA(start, end)).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited = new boolean[N+1];
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                if(visited[next]) continue;

                visited[next] = true;
                parent[0][next] = now;
                depth[next] = depth[now] + 1;

                q.offer(next);

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
