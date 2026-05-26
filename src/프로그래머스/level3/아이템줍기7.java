package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 아이템줍기7 {
    static boolean[][] visited;
    static int[][] dist;
    static int[][] board;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        board = new int[102][102];


        for(int[] r : rectangle){
            int x = r[0];
            int y = r[1];
            int x2 = r[2];
            int y2 = r[3];

            for(int i=y*2;i<=2*y2;i++){
                for(int j=x*2;j<=2*x2;j++){
                    board[i][j] = 1;
                }
            }

        }

        for(int[] r : rectangle){
            int x = r[0];
            int y = r[1];
            int x2 = r[2];
            int y2 = r[3];

            for(int i=y*2+1;i<=2*y2-1;i++){
                for(int j=x*2+1;j<=2*x2-1;j++){
                    board[i][j] = 0;
                }
            }

        }


        int answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);


        return answer / 2;
    }

    static int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        dist = new int[102][102];
        visited = new boolean[102][102];
        visited[startY][startX] = true;
        dist[startY][startX] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[y][x];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if(visited[ny][nx]) continue;

                if(board[ny][nx] == 1){
                    dist[ny][nx] = dist[y][x] + 1;
                    visited[ny][nx] = true;
                    q.offer(new int[]{nx,ny});
                }


            }
        }

        return -1;

    }
    public static void main(String[] args) throws Exception{
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

}
