package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
dfs
 */

public class 네트워크14 {
    static boolean[] visited;   //노드 방문


    public static int solution(int n, int[][] computers){
        int answer = 0;
        int m = computers[0].length;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = dfs(i, computers);
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int dfs(int node, int[][] computers){
        int size = 1;
        visited[node] = true;

        for(int j=0;j<computers[0].length;j++){
            if(!visited[j] && computers[node][j] == 1){
                size += dfs(j, computers);
            }
        }

        return size;

    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n, computers));
    }

}
