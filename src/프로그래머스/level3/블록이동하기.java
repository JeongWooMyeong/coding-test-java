package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 블록이동하기 {

    static boolean[][][][] visited;
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;

    public static int solution(int[][] board){
        n = board.length;
        m = board[0].length;

        visited = new boolean[n][m][n][m];

        answer = bfs(0,0,n-1,m-1, board);


        return answer;

    }

    static int bfs(int startX, int startY, int endX, int endY, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, startX, startY+1, 0});
        //int count = 0;
        visited[startX][startY][startX][startY+1] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            int x2 = cur[2];
            int y2 = cur[3];
            int count = cur[4];

            if((x1 == endX && y1 == endY) || (x2 == n-1 && y2 == m-1)) return count;

            //4방향 이동
            for(int i=0;i<4;i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                if(nx1 <0 || ny1 < 0 || nx2 < 0 || ny2 < 0 || nx1 >= n || ny1 >= m || nx2 >= n || ny2 >=m) continue;
                if(visited[nx1][ny1][nx2][ny2]) continue;

                if(board[nx1][ny1] == 0 && board[nx2][ny2] == 0){
                    //visited[nx1][ny1][nx2][ny2] = true;
                    //found = true;
                    //q.offer(new int[]{nx1,ny1,nx2,ny2, count+1});
                    addState(nx1, ny1, nx2, ny2, q, count);
                }
            }
            //회전해서 확인해야함

            //가로방향
            if(x1 == x2){
                //위로 회전
                if(x1-1 >= 0 && board[x1-1][y1] == 0 && board[x2-1][y2] == 0){
                    addState(x1-1,y1,x1,y1,q,count);
                    addState(x2-1,y2,x2,y2,q,count);
                }

                //아래 회전
                if(x1+1 < n && board[x1+1][y1] == 0 && board[x2+1][y2] == 0){
                    addState(x1+1,y1,x1,y1,q,count);
                    addState(x2+1,y2,x2,y2,q,count);
                }


            }
            //세로방향
            else{
                //왼쪽 회전
                if(y1-1 >= 0 && board[x1][y1-1] == 0&& board[x2][y2-1] == 0){
                    addState(x1,y1,x1,y1-1,q,count);
                    addState(x2,y2,x2,y2-1,q,count);
                }
                //오른쪽 회전
                if(y1+1 < m && board[x1][y1+1] == 0 && board[x2][y2+1] == 0){
                    addState(x1,y1,x1,y1+1,q, count);
                    addState(x2,y2,x2,y2+1,q,count);
                }

            }


        }

        return -1;
    }

    static void addState(int x, int y, int nx, int ny, Queue<int[]> q, int count){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x,y});
        list.add(new int[]{nx,ny});

        Collections.sort(list, (a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int ax = list.get(0)[0];
        int ay = list.get(0)[1];
        int bx = list.get(1)[0];
        int by = list.get(1)[1];

        if(visited[ax][ay][bx][by]) return;
        visited[ax][ay][bx][by] = true;
        q.offer(new int[]{ax,ay,bx,by, count+1});
    }

    public static void main(String[] args) throws Exception{
        int[][] board ={{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}};

        System.out.println(solution(board));
    }

}
