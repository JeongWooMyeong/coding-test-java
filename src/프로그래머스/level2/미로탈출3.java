package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 미로탈출3 {

    static char[][] board;
    static int[][] dist;
    static int n,m;
    static boolean[][] visited;
    static int[] start;
    static int[] laver;
    static int[] exit;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(String[] maps){
        n = maps.length;
        m = maps[0].length();

        board = new char[n][m];
        start = new int[2];
        laver = new int[2];
        exit = new int[2];

        for(int i=0;i<n;i++){
            String line = maps[i];
            for(int j=0;j<m;j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'L'){
                    laver[0] = i;
                    laver[1] = j;
                }else if(board[i][j] == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }else if(board[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        //레버까지 최단경로
        int distL = bfs(start[0],start[1],laver[0],laver[1]);
        if(distL == -1) return -1;
        //레버부터 출구까지
        int distE = bfs(laver[0],laver[1], exit[0],exit[1]);
        if(distE == -1) return -1;

        return distL + distE;

    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q  = new LinkedList<>();
        dist = new int[n][m];
        visited = new boolean[n][m];
        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x= cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[x][y];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] == 'X') continue;

                //if(board[nx][ny] == 'O'){
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx,ny});
                //}


            }
        }

        return -1;

    }

    public static void main(String[] args) throws Exception{
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }

}
