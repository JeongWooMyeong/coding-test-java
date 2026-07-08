package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 미로탈출7 {

    static boolean[][] visited;
    static int[][] dist;
    static int n,m;
    static char[][] board;
    static int sx,sy,lx,ly,ex,ey;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(String[] maps){
        n = maps.length;
        m = maps[0].length();

        board = new char[n][m];

        for(int i=0;i<n;i++){
            String line = maps[i];
            for(int j=0;j<m;j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(board[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }else if(board[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }


        int distL = bfs(sx,sy,lx,ly);

        if(distL == -1) return -1;

        int distE = bfs(lx,ly,ex,ey);

        if(distE == -1) return -1;


        return distL + distE;

    }

    static int bfs(int sx, int sy, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        dist = new int[n][m];

        q.offer(new int[]{sx,sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == ex && y == ey) return dist[x][y];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(board[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }


            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception{
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }


}
