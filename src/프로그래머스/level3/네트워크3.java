package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크3 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = dfs(i, n, computers);
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int dfs(int node, int n, int[][] computers){
        int size = 1;
        visited[node] = true;

        for(int i=0;i<n;i++){
            if(!visited[i] && computers[node][i] == 1){
                visited[i] = true;
                size += dfs(i, n, computers);
            }
        }

        return size;

    }

    public static void main(String[] args) throws Exception{
        int n  =3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n,computers));
    }

}
