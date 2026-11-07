package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기13 {

    static int[][] arr;
    static int[] answer;

    public static int[] solution(int rows, int columns, int[][] queries){
        arr = new int[rows][columns];

        int value = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j] = value++;
            }
        }

        answer = new int[queries.length];
        int idx = 0;

        for(int[] q : queries){
            int x1 = q[0] -1;
            int y1 = q[1] -1;
            int x2 = q[2] -1;
            int y2 = q[3] -1;

            int prev = arr[x1][y1];
            int minValue = Integer.MAX_VALUE;
            minValue = Math.min(minValue, prev);

            for(int y=y1+1;y<=y2;y++){
                int temp = arr[x1][y];
                arr[x1][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, arr[x1][y]);
            }

            for(int x=x1+1;x<=x2;x++){
                int temp = arr[x][y2];
                arr[x][y2] = prev;
                prev = temp;
                minValue = Math.min(minValue, arr[x][y2]);
            }

            for(int y=y2-1;y>=y1;y--){
                int temp = arr[x2][y];
                arr[x2][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, arr[x2][y]);
            }

            for(int x=x2-1;x>=x1;x--){
                int temp = arr[x][y1];
                arr[x][y1] = prev;
                prev = temp;
                minValue = Math.min(minValue, arr[x][y1]);
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
        System.out.println(Arrays.toString(solution(rows,columns,queries)));
    }

}
