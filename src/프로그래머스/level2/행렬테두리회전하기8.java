package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기8 {
    static int[][] map;
    static int minValue;

    public static int[] solution(int rows, int columns, int[][] queries){
        int[] answer = new int[queries.length];
        map = new int[rows][columns];

        int start = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = start;
                start++;
            }
        }

        int idx = 0;
        for(int[] query : queries){
            minValue = Integer.MAX_VALUE;
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;

            int prev = map[x1][y1];
            minValue = Math.min(minValue, prev);
            //왼쪽에서 오른쪽
            for(int y=y1+1;y<=y2;y++){
                int temp = map[x1][y];
                map[x1][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x1][y]);
            }

            //오른쪽에서 아래
            for(int x=x1+1;x<=x2;x++){
                int temp = map[x][y2];
                map[x][y2] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x][y2]);
            }

            //오른쪽에서 왼쪽
            for(int y=y2-1;y>=y1;y--){
                int temp = map[x2][y];
                map[x2][y] = prev;
                prev = temp;
                minValue = Math.min(minValue, map[x2][y]);
            }

            //왼쪽에서 위로
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
        int rows = 3;
        int columns = 3;
        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

}
