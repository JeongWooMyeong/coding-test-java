package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기4 {

    static int min;

    public static int[] solution(int rows, int columns, int[][] queries){
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        int num = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = num;
                num++;
            }
        }

        //int prev = matrix[0][0];

        for(int i=0;i<queries.length;i++){
            min = Integer.MAX_VALUE;

            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int prev = matrix[x1][y1];

            //위쪽
            for(int y=y1+1;y<=y2;y++){
                int temp = matrix[x1][y];
                matrix[x1][y] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            //오른쪽
            for(int x=x1+1;x<=x2;x++){
                int temp = matrix[x][y2];
                matrix[x][y2] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            //아래
            for(int y=y2-1;y>=y1;y--){
                int temp = matrix[x2][y];
                matrix[x2][y] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            //왼쪽
            for(int x=x2-1;x>=x1;x--){
                int temp = matrix[x][y1];
                matrix[x][y1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            answer[i] = min;

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
