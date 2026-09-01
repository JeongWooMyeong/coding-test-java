package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크42 {

    static boolean[] visited;
    static int answer;

    public static int solution(int n, int[][] computers){
        answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = bfs(i, computers);
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int bfs(int idx, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.offer(idx);
        int count = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int j=0;j<computers[now].length;j++){
                if(!visited[j] && computers[now][j] == 1){
                    visited[j] = true;
                    q.offer(j);
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
