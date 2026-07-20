package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파괴되지않은건물11 {

    static int[][] diff;
    static int n,m;
    static int answer;

    public static int solution(int[][] board, int[][] skill){
        n = board.length;
        m = board[0].length;

        answer = 0;

        diff = new int[n+2][m+2];

        for(int[] s : skill){
            int type= s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = type == 1 ? -s[5] : s[5];

            diff[r1][c1] += degree;
            diff[r1][c2+1] -= degree;
            diff[r2+1][c1] -= degree;
            diff[r2+1][c2+1] += degree;

        }

        for(int i=0;i<=n;i++){
            for(int j=1;j<=m;j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        for(int j=0;j<=m;j++){
            for(int i=1;i<=n;i++){
                diff[i][j] += diff[i-1][j];
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
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        System.out.println(solution(board, skill));
    }

}
