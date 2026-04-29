package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
누적합 : 그때 광고삽입에서 풀었던 문제랑 비슷한 원리 같다.
 */

public class 파괴되지않은건물2 {
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
            int degree = type == 1 ? -sk[5] : sk[5];

            //왼쪽위
            diff[r1][c1] += degree;
            //왼쪽위 끝
            diff[r1][c2+1] -= degree;
            //왼쪽 아래
            diff[r2+1][c1] -= degree;
            //왼쪽 끝
            diff[r2+1][c2+1] += degree;

        }

        //가로행 누적합
        for(int i=0;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        //세로행 누적합
        for(int j=0;j<m+1;j++){
            for(int i=1;i<n+1;i++){
                diff[i][j] += diff[i-1][j];
            }
        }
        //최종 합
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] += diff[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};

        System.out.println(solution(board,skill));
    }

}
