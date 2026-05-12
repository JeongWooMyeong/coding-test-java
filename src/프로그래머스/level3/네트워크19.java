package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크19 {
    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        visited = new boolean[n];
        int m = computers[0].length;
        int answer = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int count = dfs(i, computers);
                answer++;
            }
        }
        return answer;

    }

    static int dfs(int node, int[][] computers){
        visited[node] = true;
        int count = 1;      //자기 자신 포함

        for(int j=0;j<computers[0].length;j++){
            if(!visited[j] && computers[node][j] == 1){
                count += 1 + dfs(j, computers);
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
