package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 경로찾기3 {
    static int n;
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        result = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            visited = new boolean[n];
            dfs(i,i);
            for(int j=0;j<n;j++){
                if(visited[j]) result[i][j] = 1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int start, int now){
        for(int nxt = 0;nxt<n;nxt++){
            if(graph[now][nxt] == 1 && !visited[nxt]){
                visited[nxt] = true;
                dfs(start, nxt);
            }
        }
    }

}
