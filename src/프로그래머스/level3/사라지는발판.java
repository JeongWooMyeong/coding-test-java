package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 사라지는발판 {
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Result{
        boolean win;
        int turn;

        public Result(boolean win, int turn){
            this.win = win;
            this.turn = turn;
        }

    }

    public static int solution(int[][] board, int[] aloc, int[] bloc){
        n = board.length;
        m = board[0].length;

        Result res = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], true);

        return res.turn;
    }

    static Result dfs(int[][] board, int ax, int ay, int bx, int by, boolean turnA){
        int x = turnA ? ax : bx;
        int y = turnA ? ay : by;
        //발판이 0 이면 패배
        if(board[x][y] == 0) return new Result(false, 0);
        
        //1이면 현재 발판 0으로 만듬
        board[x][y] = 0;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;
        boolean canMove = false;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            //다음칸 확인 빼먹었네..
            if(board[nx][ny] == 0) continue;
            canMove = true;

            Result next;
            if(turnA){
                next = dfs(board,nx,ny,bx,by, false);
            }else{
                next = dfs(board,ax,ay,nx,ny, true);
            }
            //내가 이김
            if(!next.win){
                minWin = Math.min(minWin, next.turn+1);
            }else{
                maxLose = Math.max(maxLose, next.turn+1);
            }

            
        }
        //복구 백트래킹
        board[x][y] = 1;

        if(!canMove) return new Result(false, 0);
        if(minWin != Integer.MAX_VALUE){
            return new Result(true, minWin);
        }

        //모두 패배
        return new Result(false, maxLose);
        
    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,1,1},{1,1,1},{1,1,1}};
        int[] aloc = {1,0};
        int[] bloc = {1,2};

        System.out.println(solution(board, aloc, bloc));
    }

}
