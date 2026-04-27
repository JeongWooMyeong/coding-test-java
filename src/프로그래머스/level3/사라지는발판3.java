package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 사라지는발판3 {
    static Result result;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int m;

    static class Result{
        boolean win;
        int turn;

        public Result(boolean win, int turn){
            this.win = win;
            this.turn = turn;
        }

    }

    public static int solution(int[][] board, int[] aloc, int[] bloc){
        int answer = - 1;
        n = board.length;
        m = board[0].length;
        result = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], true);
        return result.turn;
    }

    static Result dfs(int[][] board, int ax, int ay, int bx, int by, boolean turnA){
        int x = turnA ? ax : bx;
        int y = turnA ? ay : by;

        if(board[x][y] == 0) return new Result(false, 0);
        //발판 1인건 0으로 변경
        board[x][y] = 0;
        //발판 이동 가능한지?
        boolean canMove = false;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(board[nx][ny] == 0) continue;

            canMove = true;
            Result next;
            if(turnA){
                next = dfs(board, nx, ny, bx, by, false);
            }else{
                next = dfs(board, ax, ay, nx, ny, true);
            }
            //다음 턴이 패배하면 내가 이김
            //내턴까지 돌아오므로 +1
            if(!next.win){
                minWin = Math.min(minWin, next.turn + 1);
            }else{
                maxLose = Math.max(maxLose, next.turn + 1);
            }

        }
        //발판 복구
        board[x][y] = 1;

        //이동 못했으면 패배
        if(!canMove) return new Result(false, 0);

        if(minWin != Integer.MAX_VALUE){
            return new Result(true, minWin);
        }

        return new Result(false, maxLose);
    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,1,1},{1,1,1},{1,1,1}};
        int[] aloc = {1,0};
        int[] bloc = {1,2};
        System.out.println(solution(board, aloc, bloc));
    }

}
