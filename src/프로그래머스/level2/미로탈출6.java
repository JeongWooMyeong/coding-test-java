package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 미로탈출6 {
    static char[][] board;
    static boolean[][] visited;
    static int[][] dist;
    static int n,m;
    static int SX, SY, LX, LY, EX, EY;

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
                    SX = i;
                    SY = j;
                }else if(board[i][j] == 'L'){
                    LX = i;
                    LY = j;
                }else if(board[i][j] == 'E'){
                    EX = i;
                    EY = j;
                }

            }
        }

        int distL = bfs(SX,SY,LX,LY);
        if(distL == -1) return -1;
        int distE = bfs(LX,LY,EX,EY);
        if(distE == -1) return -1;

        return distL + distE;

    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        dist = new int[n][m];
        q.offer(new int[]{startX,startY});
        visited[startX][startY] = true;
        dist[startX][startY] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[x][y];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && board[nx][ny] != 'X'){
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
