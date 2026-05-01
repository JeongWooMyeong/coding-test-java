package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
dfs로
 */

public class 네트워크10 {
    static boolean[] visited;
    static int answer = 0;

    public static int solution(int n, int[][] computers){
        visited = new boolean[n];
        int m = computers[0].length;

        for(int i=0;i<n;i++){
                if(!visited[i]){
                    int size = dfs(i, computers, m);

                    if(size > 0) answer++;
                }
        }


        return answer;
    }

    static int dfs(int node, int[][] computers, int m){
        int size = 1;
        visited[node] = true;

        for(int i=0;i<m;i++){
            if(!visited[i] && computers[node][i] == 1){
                size += dfs(i, computers, m);
            }
        }

        return size;
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(solution(n, computers));
    }

}
