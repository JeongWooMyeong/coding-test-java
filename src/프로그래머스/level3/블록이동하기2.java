package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 블록이동하기2 {
    static boolean[][][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;

    public static int solution(int[][] board){
        int answer = 0;
        n = board.length;
        m = board[0].length;
        //0 index
        visited = new boolean[n][m][n][m];
        //문제는 1,1인데 나는 0idex로 시작 그래서 n-1, m-1 지점 찾아야함
        answer = bfs(0,0,n-1,m-1,board);

        return answer;
    }

    static int bfs(int startX, int startY, int endX, int endY, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        //가로방향 시작
        q.offer(new int[]{startX, startY, startX, startY+1,0});
        visited[startX][startY][startX][startY+1] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            int x2 = cur[2];
            int y2 = cur[3];
            int count = cur[4];
            if((x1 == endX && y1 == endY) || (x2 == endX && y2 == endY)) return count;

            for(int i=0;i<4;i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                if(nx1 < 0 || nx2 <0 || ny1 < 0 || ny2 < 0 || nx1 >= n || nx2 >= n || ny1 >= m || ny2 >= m) continue;

                if(board[nx1][ny1] == 0 && board[nx2][ny2] == 0){
                    addState(nx1,ny1,nx2,ny2,count,q);
                }

            }

            //회전도 고려
            //가로방향
            if(x1 == x2){
                //위회전 고려
                if(x1-1 >= 0 && board[x1-1][y1] == 0 && board[x2-1][y2] == 0){
                    //두개의 좌표 중 하나를 축으로 하는 경우 두가지이므로 두가지 넣음
                    //x1,y1 축
                    addState(x1-1,y1,x1,y1,count,q);
                    //x2,y2 축
                    addState(x2-1,y2,x2,y2,count,q);
                }

                //아래 회전
                if(x1 +1 < n && board[x1+1][y1] == 0 && board[x2+1][y2] == 0){
                    addState(x1+1,y1,x1,y1,count,q);
                    addState(x2+1,y2,x2,y2,count,q);
                }

            }
            //세로방향
            else{
                //왼쪽 회전
                if(y1-1 >= 0 && board[x1][y1-1] == 0 && board[x2][y2-1] == 0){
                    addState(x1,y1-1,x1,y1,count,q);
                    addState(x2,y2-1,x2,y2,count,q);
                }

                //오른쪽 회전
                if(y1+1 < m && board[x1][y1+1] == 0 && board[x2][y2+1] == 0){
                    addState(x1,y1+1,x1,y1,count,q);
                    addState(x2,y2+1,x2,y2,count,q);
                }


            }

        }
        return -1;
    }

    static void addState(int x, int y, int nx, int ny, int count, Queue<int[]> q){
        int ax;
        int ay;
        int bx;
        int by;

        if(x < nx || (nx == x && y < ny)){
            ax = x;
            ay = y;
            bx = nx;
            by = ny;
        }else{
            ax = nx;
            ay = ny;
            bx = x;
            by = y;
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
