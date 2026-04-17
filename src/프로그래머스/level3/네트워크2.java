package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크2 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            //이조건만 써도 맞음
            //근데 만약 자기자신이 무조건 1이라는 조건 없으면 answer++ 무조건 안됌
            if(!visited[i]){
                //i노드 기준으로 dfs 돌림
                int size = dfs(i,n, computers);
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int dfs(int node, int n, int[][] computers){
        visited[node] = true;
        int size = 1;

        for(int j=0;j<n;j++){
            if(!visited[j] && computers[node][j] == 1){
                visited[j] = true;
                size += dfs(j, n, computers);
            }
        }
        return size;
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{0,0,0},{0,0,0},{0,0,0}};


        System.out.println(solution(n, computers));
    }
}
