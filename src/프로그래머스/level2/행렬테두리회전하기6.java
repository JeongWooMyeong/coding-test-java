package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기6 {
    static int minValue;
    static int[][] map;

    public static int[] solution(int rows, int columns, int[][] queries){
        map = new int[rows][columns];

        int value = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = value;
                value++;
            }
        }

        int[] answer = new int[queries.length];

        int idx = 0;
        for(int[] query : queries){

            minValue = Integer.MAX_VALUE;

            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;

            int prev = map[x1][y1];
            //위 -> 오른쪽
            for(int y=y1+1;y<=y2;y++){
                int temp = map[x1][y];
                map[x1][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x1][y]);
            }

            //오른쪽 -> 아래
            for(int x=x1+1;x<=x2;x++){
                int temp = map[x][y2];
                map[x][y2] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x][y2]);
            }

            //오른쪽 -> 왼쪽
            for(int y=y2-1;y>=y1;y--){
                int temp = map[x2][y];
                map[x2][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x2][y]);
            }

            //왼쪽 -> 위
            for(int x=x2-1;x>=x1;x--){
                int temp = map[x][y1];
                map[x][y1] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x][y1]);
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

        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

}
