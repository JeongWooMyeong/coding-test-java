package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs
 */

public class 네트워크20 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        int m = computers[0].length;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    static int bfs(int start, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int count = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<computers[0].length;i++){
                if(!visited[i] && computers[now][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                    count++;
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
