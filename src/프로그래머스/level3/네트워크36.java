package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크36 {

    static boolean[] visited;
    static int m;

    public static int solution(int n, int[][] computers){

        visited = new boolean[n];
        //m = computers[0].length;
        int answer = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i,computers);
                answer++;
            }
        }

        return answer;

    }

    static void bfs(int node, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<computers[now].length;i++){
                if(!visited[i] && computers[now][i] == 1){
                    visited[i] = true;
                    q.offer(i);
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
