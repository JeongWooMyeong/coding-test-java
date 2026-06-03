package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크21 {
    static boolean[] visited;
    static int m;

    public static int solution(int n, int[][] computers){

        visited = new boolean[n+1];

        m = computers[0].length;
        int answer = 0;

        for(int i=0;i<n;i++){
            //두번 체크할 필요는 없음.. dfs에서 체크하기 때문에
            //for(int j=0;j<m;j++) {
            if (!visited[i]) {
                int size = dfs(i, n, computers);

                answer++;

            }
            //}
        }

        return answer;
    }

    static int dfs(int node, int n, int[][] computers){
        visited[node] = true;
        int count = 1;

        for(int j=0;j<computers[node].length;j++){
            if(!visited[j] && computers[node][j] == 1){
                count += 1 + dfs(j, n, computers);
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
