package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기10 {

    static int[][] board;
    static int minValue;

    public static int[] solution(int rows, int columns, int[][] queries){
        board = new int[rows][columns];

        int value = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                board[i][j] = value;
                value++;
            }
        }

        int[] answer = new int[queries.length];
        int idx = 0;

        for(int[] q : queries){
            int x1 = q[0]-1;
            int y1 = q[1]-1;
            int x2 = q[2]-1;
            int y2 = q[3]-1;
            minValue = Integer.MAX_VALUE;

            int prev = board[x1][y1];
            minValue = Math.min(minValue, prev);

            for(int y=y1+1;y<=y2;y++){
                int temp = board[x1][y];
                board[x1][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, prev);
            }

            for(int x=x1+1;x<=x2;x++){
                int temp = board[x][y2];
                board[x][y2] = prev;
                prev = temp;
                minValue = Math.min(minValue, prev);
            }

            for(int y=y2-1;y>=y1;y--){
                int temp = board[x2][y];
                board[x2][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, board[x2][y]);
            }


            for(int x=x2-1;x>=x1;x--){
                int temp = board[x][y1];
                board[x][y1] = prev;
                prev = temp;
                minValue = Math.min(minValue, board[x][y1]);
            }

            answer[idx] = minValue;
            idx++;

        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        System.out.println(Arrays.toString(solution(rows,columns, queries)));

    }

}
