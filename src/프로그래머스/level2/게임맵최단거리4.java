package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 게임맵최단거리4 {
    static boolean[][] visited;
    static int[][] dist;
    static int n, m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] maps){
        int answer = -1;
        n = maps.length;
        m = maps[0].length;

        answer = bfs(0, 0, n-1, m-1, maps);

        return answer;
    }

    static int bfs(int startX, int startY, int endX , int endY, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        dist = new int[n][m];
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        dist[startX][startY] = 1;       //처음 시작칸 포함

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[x][y];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }

            }
        }
        //해당 경로까지 도달 못하면 -1 리턴
        return -1;

    }

    public static void main(String[] args) throws Exception{
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(maps));
    }

}
