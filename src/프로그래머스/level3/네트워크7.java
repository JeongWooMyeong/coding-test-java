package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
DFS
 */

public class 네트워크7 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }


        return answer;
    }

    static void dfs(int node, int[][] computers){
        visited[node] = true;
        int m = computers[0].length;

        for(int j=0;j<m;j++){
            if(computers[node][j] == 1 && !visited[j]){
                dfs(j, computers);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n, computers));
    }

}
