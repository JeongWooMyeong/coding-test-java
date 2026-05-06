package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs
 */

public class 네트워크15 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];
        int m = computers[0].length;

        for(int i=0;i<n;i++){
           if(!visited[i]){
               bfs(i, computers);
               answer++;
           }
        }



        return answer;
    }

    static void bfs(int node, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int j=0;j<computers[0].length;j++){
                if(!visited[j] && computers[now][j] == 1){
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n, computers));
    }

}
