package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
난 단순히 1의 개수로 생각해서 dfs로 풀엇는데 아니였음
computers[i][j]는 i,j번 컴퓨터가 연결되어 있으면 1로 표현
 */

public class 네트워크 {
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int n, int[][] computers){
        int answer = 0;
        //arr = new int[n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    if(computers[i][j] == 1){
                        dfs(i,j, n, computers);
                        answer++;
                    }
                }
            }
        }



        return answer;
    }

    static void dfs(int x, int y, int n, int[][] computers){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(visited[nx][ny]) continue;

            if(computers[nx][ny] == 1){
                visited[nx][ny] = true;
                dfs(nx, ny, n, computers);
            }

        }
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(solution(n, computers));
    }

}
