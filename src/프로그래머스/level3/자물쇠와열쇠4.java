package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 자물쇠와열쇠4 {

    static int[][] board;
    static int n,m;

    public static boolean solution(int[][] key, int[][] lock){
        n = lock.length;
        m = key.length;

        board = new int[3*n][3*n];

        //lock 가운데에 채우기
        for(int i=n;i<2*n;i++){
            for(int j=n;j<2*n;j++){
                board[i][j] = lock[i%n][j%n];
            }
        }

        for(int r=0;r<4;r++){
            //key 회전
            key = rotate(key, m);
            for(int x=0;x<2 * n;x++){
                for(int y=0;y<2 * n;y++){
                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] += key[i][j];
                        }
                    }

                    if(match(board)) return true;

                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++)
                            board[x+i][y+j] -= key[i][j];
                    }

                }
            }
        }

        return false;
    }

    static int[][] rotate(int[][] key, int n){
        int[][] result = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                result[i][j] = key[j][n-i-1];
            }
        }

        return result;
    }

    static boolean match(int[][] board){
        for(int i=n;i<2*n;i++){
            for(int j=n;j<2*n;j++){
                if(board[i][j] != 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(solution(key, lock));
    }

}
