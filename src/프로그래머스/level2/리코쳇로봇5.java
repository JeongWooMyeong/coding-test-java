package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 리코쳇로봇5 {

    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int rx,ry;
    static int gx,gy;
    static int answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(String[] board){
        n = board.length;
        m = board[0].length();

        map = new char[n][m];

        for(int i=0;i<n;i++){
            String line = board[i];
            for(int j=0;j<line.length();j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }else if(map[i][j] == 'G'){
                    gx = i;
                    gy = j;
                }
            }
        }

        answer = bfs();

        return answer;
    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rx,ry,0});
        visited = new boolean[n][m];
        visited[rx][ry] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(x == gx && y == gy) return count;

            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;

                while(true){
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    if(tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] == 'D'){
                        break;
                    }

                    nx = tx;
                    ny = ty;

                }

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,count+1});
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
