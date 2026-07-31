package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크37 {

    static boolean[] visited;
    static int answer;

    public static int solution(int n, int[][] computers){
        visited = new boolean[n];
        answer = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int size = dfs(i, computers);
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int dfs(int node, int[][] computers){
        visited[node] = true;
        int count = 1;

        for(int j=0;j<computers[node].length;j++){
            if(!visited[j] && computers[node][j] == 1){
                count += dfs(j, computers);
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
