package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스도쿠5 {

    static int[][] board;
    static List<int[]> empty;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        empty = new ArrayList<>();

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0){
                    empty.add(new int[]{i,j});
                }
            }
        }

        dfs(0, board);

    }

    static void dfs(int idx, int[][] board){
        if(idx == empty.size()){
            printBoard(board);
            System.exit(0);
            return;
        }

        int[] cur = empty.get(idx);
        int r = cur[0];
        int c = cur[1];

        for(int value=1;value<=9;value++){
            if(match(r,c,value)){
                board[r][c] = value;
                dfs(idx+1, board);
                board[r][c] = 0;
            }
        }

    }

    static boolean match(int row, int col, int value){
        for(int c=0;c<9;c++){
            if(board[row][c] == value) return false;
        }

        for(int r=0;r<9;r++){
            if(board[r][col] == value) return false;
        }

        int startR = row / 3 * 3;
        int startC = col / 3 * 3;

        for(int r=startR;r<startR+3;r++){
            for(int c=startC;c<startC+3;c++){
                if(board[r][c] == value) return false;
            }
        }

        return true;
    }

    static void printBoard(int[][] board){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                sb.append(board[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}
