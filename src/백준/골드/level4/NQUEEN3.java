package 백준.골드.level4;

import java.util.*;
import java.io.*;

//퀸은 같은 열, 대각선에 넣을 수 없다.

public class NQUEEN3 {
    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N];

        //for(int i=0;i<N;i++){
            backtrack(0);
        //}

        System.out.print(count);

    }

    static void backtrack(int row){
        if(row == N){
            count++;
            return;
        }

        for(int col=0;col<N;col++){
            if(isSafe(row, col)){
                board[row] = col;
                backtrack(row+1);
            }
        }

    }

    static boolean isSafe(int row, int col){
        for(int i=0;i<row;i++){
            if(board[i] == col) return false;
            if(Math.abs(row - i) == Math.abs(board[i] - col)) return false;
        }

        return true;
    }


}
