package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스도쿠4 {

    static int[][] board;
    static List<int[]> empty;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        empty = new ArrayList<>();

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) empty.add(new int[]{i,j});
            }
        }

        sb = new StringBuilder();

        dfs(0);

    }

    static void dfs(int idx){
        if(idx == empty.size()){
            printBoard();
            System.exit(0);
            return;
        }

        int[] cur = empty.get(idx);
        int row = cur[0];
        int col = cur[1];

        for(int value=1;value<=9;value++){
            if(isCheck(row,col,value)){
                board[row][col] = value;
                dfs(idx+1);
                board[row][col] = 0;
            }
        }

    }

    static boolean isCheck(int row, int col, int value){

        for(int c=0;c<9;c++){
            if(c == col) continue;
            if(board[row][c] == value) return false;
        }

        for(int r=0;r<9;r++){
            if(r == row) continue;
            if(board[r][col] == value) return false;
        }

        int startR = row / 3 * 3;
        int startC = col / 3 * 3;

        for(int r=startR;r<startR+3;r++){
            for(int c=startC;c<startC+3;c++){
                if(r == row && c == col) continue;
                if(board[r][c] == value) return false;
            }
        }

        return true;
    }

    static void printBoard(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(board[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
