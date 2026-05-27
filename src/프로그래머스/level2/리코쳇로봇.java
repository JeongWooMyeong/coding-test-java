package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 리코쳇로봇 {
    static char[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int n,m;
    static int RX, RY, GX, GY;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(String[] board){
        n = board.length;
        m = board[0].length();

        map = new char[n][m];

        for(int i=0;i<n;i++){
            String line = board[i];
            for(int j=0;j<m;j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'R'){
                    RX = i;
                    RY = j;
                }else if(map[i][j] == 'G'){
                    GX = i;
                    GY = j;
                }
            }
        }

        int answer = bfs(RX,RY,GX,GY);

        return answer;

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
                int nx = x;
                int ny = y;

                while(true){
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    if(tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] == 'D') break;
                    nx = tx; ny = ty;
                }

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }



            }


        }

        return -1;

    }

    public static void main(String[] args) throws Exception{
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }

}
