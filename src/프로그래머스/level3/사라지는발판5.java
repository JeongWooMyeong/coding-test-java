package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 사라지는발판5 {
    static class Result{
        boolean win;
        int turn;

        public Result(boolean win, int turn){
            this.win = win;
            this.turn = turn;
        }

    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;

    public static int solution(int[][] board, int[] aloc, int[] bloc){
        n = board.length;
        m = board[0].length;

        Result answer =dfs(aloc[0],aloc[1],bloc[0],bloc[1], board, true);
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
        //사용한 발판이면 return false, 0
        if(board[x][y] == 0) return new Result(false, 0);

        //아니라면 발판 사용
        board[x][y] = 0;
        //움직였는지 falg
        boolean canMove = false;
        //최소로 이길수 있는 턴 수, 최대로 지는 터 수 지역변수 선언
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //범위 넘거나 사용한 발판이면 넘어감
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(board[nx][ny] == 0 ) continue;

            canMove = true;
            Result next;
            if(turnA){
                //B턴으로 넘김
                next = dfs(nx,ny,bx,by,board,false);
            }else{
                //A턴으로 넘김
                next = dfs(ax,ay,nx,ny,board,true);

            }
            //다음턴이 false라면 지금 내가 이김
            if(!next.win){
                minWin = Math.min(minWin, next.turn + 1);
            }else{
                maxLose = Math.max(maxLose, next.turn + 1);
            }


        }

        board[x][y] = 1;

        //탐색이 끝난 후
        //내가 이동한 흔적이 없으면
        if(!canMove) return new Result(false, 0);

        //탐색 종료 후 miinWin이 있으면 minWin 반환
        if(minWin != Integer.MAX_VALUE) return new Result(true, minWin);

        //minWin도 없으면 maxLose
        return new Result(false, maxLose);

    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,1,1},{1,1,1},{1,1,1}};
        int[] aloc = {1,0};
        int[] bloc = {1,2};
        System.out.println(solution(board, aloc, bloc));
    }

}
