package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크31 {

    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;

        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = bfs(i, computers, n);
                answer++;
            }
        }

        return answer;
    }

    static int bfs(int start, int[][] computers, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int count = 1;
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<computers[now].length;i++){
                if(!visited[i] && computers[now][i] == 1){
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n, computers));
    }


}
