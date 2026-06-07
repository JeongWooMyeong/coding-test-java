package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬의곱셈2 {

    static int[][] answer;

    public static int[][] solution(int[][] arr1, int[][] arr2){
        int rows = arr1.length;
        int columns = arr2[0].length;
        int n = arr2.length;

        answer = new int[rows][columns];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                for(int k=0;k<n;k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};
        System.out.println(Arrays.deepToString(solution(arr1,arr2)));
    }

}
