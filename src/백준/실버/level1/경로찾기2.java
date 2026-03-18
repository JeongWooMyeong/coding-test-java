package 백준.실버.level1;

import java.io.*;
import java.util.*;

public class 경로찾기2 {
    static int N;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N][N];

        //각 노드에서 DFS 수행
        for(int i=0;i<N;i++){
            visited = new boolean[N];
            dfs(i, i, result);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int start, int cur, int[][] result){
        for(int next = 0;next<N;next++){
            if(graph[cur][next] == 1 && !visited[next]){
                visited[next] = true;
                result[start][next]  = 1;
                dfs(start, next, result);
            }
        }
    }

}
