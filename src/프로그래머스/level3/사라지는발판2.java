package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 사라지는발판2 {
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

        Result res = dfs(board, aloc[0],aloc[1],bloc[0],bloc[1], true);
        return res.turn;
    }

    static Result dfs(int[][] board, int ax, int ay, int bx, int by, boolean turnA){
        int x = turnA ? ax : bx;
        int y = turnA ? ay : by;
        //발판 이동 할 수 없으면 (0, 발판 없음 1, 발판 있음) 패배
        if(board[x][y] == 0) return new Result(false, 0);
        //최소로 이길 수 있는 경우
        int minWin = Integer.MAX_VALUE;
        //최대 끌어서 지는 경우
        int maxLose = 0;

        //발판 0처리 해주었으니 1인 발판은 밟았으니 0처리
        board[x][y] = 0;
        //발판 이동가능한지 여부
        boolean canMove = false;

        //4방향 이동
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //범위 벗어나거나 발판 아니면 이동 못함
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(board[nx][ny] == 0) continue;

            //예외 조건 넘어가면 발판 넘어갌 있으니 이동처리
            canMove = true;
            //이동하고 다음 턴 넘김 (turnA에 따른 dfs
            Result next;
            if(turnA){
                next = dfs(board, nx,ny,bx,by, false);
            }else{
                next = dfs(board, ax,ay,nx,ny, true);
            }
            //다음턴에 지는 경우 발생하면
            if(!next.win){
                //이전턴에 있는 사람 이김
                minWin = Math.min(minWin, next.turn + 1);
            }else{
                maxLose = Math.max(maxLose, next.turn + 1);
            }

        }

        //이동 경우 다 끝내고 원상복구 (다른 경우 찾기 위해_
        board[x][y] = 1;

        //이동 못하면 패배
        if(!canMove) return new Result(false, 0);
        //승리하는 경우 있으면 return (최적의 경우는 위에서 계산
        if(minWin != Integer.MAX_VALUE) return new Result(true, minWin);

        //2가지 경우 없다면- 지는 경우 (최대로 버텨서)
        return new Result(false, maxLose);



    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,1,1},{1,1,1},{1,1,1}};
        int[] aloc = {1,0};
        int[] bloc = {1,2};

        System.out.println(solution(board, aloc, bloc));
    }

}
