package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 사라지는발판4 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    //static int minWin = Integer.MAX_VALUE;
    //static int maxLose = Integer.MAX_VALUE;

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

        Result answer = dfs(aloc[0],aloc[1],bloc[0],bloc[1],board,true);

        return answer.turn;
    }

    static Result dfs(int ax, int ay, int bx, int by, int[][] board, boolean turnA){
        int x, y;
        if(turnA){
            x = ax;
            y = ay;
        }else{
            x = bx;
            y = by;
        }
        if(board[x][y] == 0) return new Result(false, 0);

        //현재 발판 사용했으니 0으로 변환
        board[x][y] = 0;

        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;

        boolean canMove = false;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(board[nx][ny] == 0) continue;

            canMove = true;
            Result next;
            //현재 A턴이면 B턴으로 넘김
            if(turnA){
                next = dfs(nx, ny, bx, by, board, false);
            }else{
                next = dfs(ax, ay, nx, ny, board, true);
            }
            //다음턴에 못움직이면 승리
            if(!next.win){
                minWin = Math.min(minWin, next.turn+1);
            }else{
                maxLose = Math.max(maxLose, next.turn+1);
            }


        }
        //복구
        board[x][y] = 1;

        //만약 움직이지 못한다면 turn은 0
        if(!canMove) return new Result(false, 0);

        //
        if(minWin != Integer.MAX_VALUE) return new Result(true, minWin);

        return new Result(false, maxLose);


    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,1,1},{1,1,1},{1,1,1}};
        int[] aloc = {1,0};
        int[] bloc = {1,2};
        System.out.println(solution(board, aloc, bloc));
    }

}
