package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs
 */

public class 네트워크22 {

    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;

        visited = new boolean[n+1];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = bfs(i, computers);
                if(size > 0 ) answer++;
            }
        }

        return answer;
    }

    static int bfs(int start, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int j=0;j<computers[now].length;j++){
                if(!visited[j] && computers[now][j] == 1){
                    visited[j] = true;
                    count++;
                    q.offer(j);
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
