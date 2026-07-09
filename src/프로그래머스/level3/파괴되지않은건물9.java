package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 파괴되지않은건물9 {

    static int[][] diff;
    static int n,m;

    public static int solution(int[][] board, int[][] skill){
        int answer = 0;
        n = board.length;
        m = board[0].length;

        diff = new int[n+2][m+2];

        for(int[] s : skill){
            int type = s[0];
            int x1 = s[1];
            int y1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            int degree = type == 1 ? -s[5] : s[5];

            diff[x1][y1] += degree;
            diff[x2+1][y1] -= degree;
            diff[x1][y2+1] -= degree;
            diff[x2+1][y2+1] += degree;

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
