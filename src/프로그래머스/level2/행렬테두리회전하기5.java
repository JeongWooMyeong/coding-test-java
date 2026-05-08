package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기5 {
    static int[][] board;
    
    public static int[] solution(int rows, int columns, int[][] queries){
        
        board = new int[rows][columns];
        //1. 보드 숫자로 채우기 (그상태에서 회전하기 때문에 배열 복사할 필요 없을듯)
        int start = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                board[i][j] = start;
                start++;
            }
        }

        //2. queries 배열 돌면서 최소값 구하기
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int[] q : queries) {
            int min = Integer.MAX_VALUE;
            int x1 = q[0]-1;    //0 index
            int y1 = q[1]-1;
            int x2 = q[2]-1;
            int y2 = q[3]-1;

            //값 저장하기 위해 prev
            int prev = board[x1][y1];
            //처음시작점 -> 오른쪽
            for(int y=y1+1;y<=y2;y++){
                int temp = board[x1][y];
                board[x1][y] = prev;
                prev = temp;
                min = Math.min(board[x1][y], min);
            }

            //오른쪽에서 아래로
            for(int x=x1+1;x<=x2;x++){
                int temp = board[x][y2];
                board[x][y2] = prev;
                prev = temp;
                min = Math.min(board[x][y2], min);
            }

            //아래에서 왼쪽으로
            for(int y=y2-1;y>=y1;y--){
                int temp = board[x2][y];
                board[x2][y] = prev;
                prev = temp;
                min = Math.min(board[x2][y], min);
            }

            //왼쪽-> 출발점
            for(int x=x2-1;x>=x1;x--){
                int temp = board[x][y1];
                board[x][y1] = prev;
                prev = temp;
                min = Math.min(board[x][y1], min);
            }

            answer[idx] = min;
            idx++;

        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
    
}
