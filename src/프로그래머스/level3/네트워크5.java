package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크5 {
    static boolean[] visited;   //각 네트워크에 대한 방문 여부

    public static int solution(int n, int[][] computers){
        int answer = 0;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                //각 노드에 대한 네트워크 연결 확인
                int size = dfs(i, n, computers);
                //size가 0보다 크면 연결된게 하나라도 있다는 소리
                if(size > 0) answer++;
            }
        }

        return answer;
    }

    static int dfs(int node, int n, int[][] computers){
        int size = 1;   //네트워크 개수 세기 용
        visited[node] = true;

        for(int i=0;i<n;i++){
            if(!visited[i] && computers[node][i] == 1){
                size += dfs(i, n, computers);
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
