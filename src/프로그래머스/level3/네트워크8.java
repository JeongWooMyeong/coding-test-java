package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크8 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i, computers, n);
                answer++;
            }
        }

        return answer;
    }

    static void bfs(int start, int[][] computers, int n){
        int m = computers[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int j=0;j<m;j++){
                if(!visited[j] && computers[node][j] == 1){
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
