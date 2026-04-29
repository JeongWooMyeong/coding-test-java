package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파괴되지않은건물 {
    public static int solution(int[][] board, int[][] skill){
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n+1][m+1];

        for(int[] sk : skill){
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = type== 1 ? -sk[5] : sk[5];

            diff[r1][c1] += degree;
            diff[r1][c2+1] -= degree;
            diff[r2+1][c1] -= degree;
            diff[r2+1][c2+1] += degree;

        }

        //가로 누적합 계산
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        //세로 누적합 계산
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                diff[i][j] += diff[i-1][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] += diff[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }



        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        System.out.println(solution(board, skill));
    }

}
