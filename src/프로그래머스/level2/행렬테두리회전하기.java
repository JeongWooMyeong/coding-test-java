package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
제대로 못짬 -> 동작 안함..

 */

public class 행렬테두리회전하기 {
    static int[][] board;

    public static int solution(int rows, int columns, int[][] queries){
        board = new int[rows][columns];

        int value = 1;
        //rows, columns 배열 채우기
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                board[i][j] = value;
                value++;
            }
        }

        int startX = 2;
        int startY = 2;
        int endX = 5;
        int endY = 4;

        int answer = rotate(board, startX-1, startY-1, endX-1, endY-1, rows, columns);

        return answer;
    }

    static int rotate(int[][] board, int x1, int y1, int x2, int y2, int rows, int columns){
        int temp = board[x1][y1];
        int minValue = Integer.MAX_VALUE;

        //위
        for(int i=y1;i<y2;i++){

            board[x1][i + 1] = board[x1][i];
            minValue = Math.min(minValue, board[x1][i]);

        }
        //오른쪽
        for(int i=x1;i<x2;i++){

            board[i+1][y2] = board[i][y2];
            minValue = Math.min(minValue, board[i+1][y2]);

        }

        //아래
        for(int i=y2;i>y1;i--){
            board[x2][i] = board[x2][i-1];
            minValue = Math.min(minValue, board[x2][i]);
        }

        //왼
        for(int i=x2;i>x1;i--){
            board[i][y1] = board[i-1][y1];
            minValue = Math.min(minValue, board[i][y1]);

        }

        board[x1][y1] = temp;

        return minValue;

    }

    public static void main(String[] args) throws Exception{

    }

}
