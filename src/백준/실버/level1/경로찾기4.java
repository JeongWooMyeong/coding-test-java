package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 경로찾기4 {
    static int N;
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        result = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            bfs(i);
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

    static void bfs(int start){
        visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        //visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int nxt=0;nxt<N;nxt++){
                if(graph[now][nxt] == 1 && !visited[nxt]){
                    visited[nxt] = true;
                    result[start][nxt] = 1;
                    q.offer(nxt);
                }
            }
        }
    }

}
