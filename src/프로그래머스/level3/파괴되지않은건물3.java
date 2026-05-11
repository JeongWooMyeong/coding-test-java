package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파괴되지않은건물3 {

    public static int solution(int[][] board, int[][] skill){
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        int[][] diff = new int[n+1][m+1];
//        for(int i=0;i<board.length;i++){
//            diff[i] = board[i].clone();
//        }

        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = type == 1 ? -s[5] : s[5];
            //갑자기 헷갈리는게 왜 범위 +1 이였지?
            //왼쪽위
            diff[r1][c1] += degree;
            //오른쪽 위
            diff[r1][c2+1] -= degree;
            //왼쪽 아래
            diff[r2+1][c1] -= degree;
            //오른쪽 알
            diff[r2+1][c2+1] += degree;

        }

        //누적합 구하기 행 세로행
        for(int j=0;j<m+1;j++){
            for(int i=1;i<n+1;i++){
                diff[i][j] += diff[i-1][j];
            }
        }
        //가로행
        for(int i=0;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] + diff[i][j] >= 1) answer++;
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
