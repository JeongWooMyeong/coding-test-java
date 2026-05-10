package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크17 {

    static boolean[] visited;

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]) {
                int size = dfs(i, computers, n);
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int dfs(int node, int[][] computers, int n){
        visited[node] = true;
        int count = 1;  //자기 자신

        for(int j=0;j<n;j++){
            if(computers[node][j] == 1 && !visited[j]){
                count += 1 + dfs(j, computers, n);
            }
        }

        return count;

    }

    public static void main(String[] args ) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(solution(n, computers));

    }

}
