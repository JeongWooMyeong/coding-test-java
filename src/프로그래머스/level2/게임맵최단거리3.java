package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 게임맵최단거리3 {
    static int n,m;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] maps){
        int answer = 0;
        n = maps.length;
        m = maps[0].length;

        answer = bfs(0,0, maps);



        return answer;
    }

    static int bfs(int a, int b, int[][] maps){
        visited = new boolean[n][m];
        dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});
        dist[a][b] = 1; //처음도 개수로 침
        visited[a][b] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == n-1 && y == m-1) return dist[x][y];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }


            }

        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(maps));
    }

}
