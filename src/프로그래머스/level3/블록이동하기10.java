package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 블록이동하기10 {

    static boolean[][][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int answer;

    public static int solution(int[][] board){
        n = board.length;
        m = board[0].length;

        answer = 0;

        visited = new boolean[n][m][n][m];

        answer = bfs(0,0,0,1, board);

        return answer;
    }

    static int bfs(int sx1, int sy1, int sx2, int sy2, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx1,sy1,sx2,sy2,0});
        visited[sx1][sy1][sx2][sy2] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            int x2 = cur[2];
            int y2 = cur[3];
            int count = cur[4];

            if((x1 == n-1 && y1 == m-1) || (x2 == n-1 && y2 == m-1)) return count;

            for(int i=0;i<4;i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                if(nx1 < 0 || ny1 < 0 || nx2 < 0 || ny2 < 0 || nx1 >= n || nx2 >= n || ny1 >= m || ny2 >= m) continue;

                if(board[nx1][ny1] == 0 && board[nx2][ny2] == 0) {
                    addState(nx1, ny1, nx2, ny2, count, q);
                }
            }

            if(x1 != x2){
                if(y1+1 < m && board[x1][y1+1] != 1 && board[x2][y2+1] != 1){

                    addState(x1,y1,x1,y1+1,count,q);
                    addState(x2,y2,x2,y2+1,count,q);

                }

                if(y1-1 >= 0 && board[x1][y1-1] != 1 && board[x2][y2-1] != 1){
                    addState(x1,y1,x1,y1-1,count,q);
                    addState(x2,y2,x2,y2-1,count,q);
                }

            }else{

                if(x1+1 < n && board[x1+1][y1] != 1 && board[x2+1][y2] != 1){
                    addState(x1,y1,x1+1,y1,count,q);
                    addState(x2,y2,x2+1,y2,count,q);
                }

                if(x1-1 >= 0 && board[x1-1][y1] != 1 && board[x2-1][y2] != 1){

                    addState(x1,y1,x1-1,y1,count,q);
                    addState(x2,y2,x2-1,y2,count,q);
                }

            }

        }

        return -1;
    }


    static void addState(int x1, int y1, int x2, int y2, int count, Queue<int[]> q){
        int ax,ay,bx,by;

        if(x1 > x2 || (x1==x2 && y1 > y2)){
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
