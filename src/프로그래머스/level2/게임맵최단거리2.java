package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 게임맵최단거리2 {
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;

    public static int solution(int[][] maps){
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        dist = new int[n][m];

        answer = bfs(0, 0, n, m, maps, visited);

        return answer;
    }

    static int bfs(int x, int y, int start, int end, int[][] maps, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 1;
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == start-1 && cur[1] == end-1) return dist[cur[0]][cur[1]];
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
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
