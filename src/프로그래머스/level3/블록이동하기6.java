package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 블록이동하기6 {

    static boolean[][][][] visited;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] board){
        n = board.length;
        m = board[0].length;

        int answer = bfs(0,0,0,1,board);

        return answer;
    }


    static int bfs(int x1, int y1, int x2, int y2, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m][n][m];
        q.offer(new int[]{x1,y1,x2,y2,0});
        visited[x1][y1][x2][y2] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ax = cur[0];
            int ay = cur[1];
            int bx = cur[2];
            int by = cur[3];
            int count = cur[4];

            if((ax == n-1 && ay == m-1) || (bx == n-1 && by == m-1)) return count;

            for(int i=0;i<4;i++){
                int nx1 = ax + dx[i];
                int ny1 = ay + dy[i];
                int nx2 = bx + dx[i];
                int ny2 = by + dy[i];

                if(nx1 < 0 || ny1 < 0 || nx1 >= n || ny1 >= m || nx2 >= n || ny2 >= m) continue;

                if(!visited[nx1][ny1][nx2][ny2] && board[nx1][ny1] == 0 && board[nx2][ny2] == 0){
                    addState(nx1, ny1, nx2, ny2,count, q);
                }

            }

            //회전 (가로 방향)
            if(ax == bx){
                //위 방향
                if(ax-1>=0 && board[ax-1][ay] != 1 && board[ax-1][by] != 1){
                    addState(ax,ay,ax-1,ay,count,q);
                    addState(bx,by,ax-1,by,count,q);
                }
                //아래방향
                if(ax+1<n && board[ax+1][ay] != 1 && board[ax+1][by] != 1){
                    addState(ax,ay,ax+1,ay,count,q);
                    addState(bx,by,ax+1,by,count,q);
                }
            //세로방향
            }else{
                //왼쪽
                if(ay-1>=0 && board[ax][ay-1] != 1 && board[bx][ay-1] != 1){
                    addState(ax,ay,ax,ay-1,count,q);
                    addState(bx,by,bx,by-1,count,q);
                }

                //오른쪽
                if(ay+1<m && board[ax][ay+1] != 1 && board[bx][by+1] != 1){
                    addState(ax,ay,ax,ay+1,count,q);
                    addState(bx,by,bx,by+1,count,q);
                }
            }


        }

        return -1;
    }

    static void addState(int x1, int y1, int x2, int y2, int count, Queue<int[]> q){

        int ax;
        int ay;
        int bx;
        int by;

        if((x1 > x2) || (x1==x2 && y1 > y2) ){
            ax = x2;
            ay = y2;
            bx = x1;
            by = y1;
        }else{
            ax = x1;
            ay = y1;
            bx = x2;
            by = y2;
        }

        if(visited[ax][ay][bx][by]) return;

        visited[ax][ay][bx][by] = true;
        q.offer(new int[]{ax,ay,bx,by,count+1});

    }

    public static void main(String[] args) throws Exception{
        int[][] board ={{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}};

        System.out.println(solution(board));
    }

}
