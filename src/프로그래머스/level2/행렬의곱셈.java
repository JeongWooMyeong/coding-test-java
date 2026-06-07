package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 행렬의곱셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2){
        int rows = arr1.length;
        int columns = arr2[0].length;
        int n = arr2.length;

        int[][] answer = new int[rows][columns];

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
        int[][] arr1 = {{2,3,2},{4,2,4},{3,1,4}};
        int[][] arr2 = {{5,4,3},{2,4,1},{3,1,1}};

        System.out.println(Arrays.deepToString(solution(arr1,arr2)));
    }

}
