package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 게임맵최단거리5 {
    static int n,m;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] maps){
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        dist = new int[n][m];

        int answer = bfs(0,0,n-1,m-1,maps);

        return answer;
    }

    static int bfs(int sx, int sy, int ex, int ey, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        visited[sx][sy] = true;
        //int count = 1;
        dist[sx][sy] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == ex && y == ey) return dist[x][y];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
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
