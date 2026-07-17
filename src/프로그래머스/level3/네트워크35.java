package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크35 {

    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        int m = computers[0].length;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[j]){
                    int count = dfs(j, computers);
                    if(count > 0) answer++;
                }
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
