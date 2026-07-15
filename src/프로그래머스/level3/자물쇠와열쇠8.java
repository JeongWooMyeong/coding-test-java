package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 자물쇠와열쇠8 {

    static int n,m;
    static int[][] board;

    public static boolean solution(int[][] key, int[][] lock){
        n = lock.length;
        m = key.length;

        board = new int[3*n][3*n];

        for(int i=n;i<2*n;i++){
            for(int j=n;j<2*n;j++){
                board[i][j] = lock[i%n][j%n];
            }
        }

        for(int x=0;x<=3*n-m;x++){
            for(int y=0;y<=3*n-m;y++){
                for(int d=0;d<4;d++){
                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] += key[i][j];
                        }
                    }

                    if(match()) return true;

                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] -= key[i][j];
                        }
                    }

                    key = rotate(key);

                }
            }
        }

        return false;
    }

    static boolean match(){
        for(int i=n;i<2*n;i++){
            for(int j=n;j<2*n;j++){
                if(board[i][j] != 1) return false;
            }
        }

        return true;
    }

    static int[][] rotate(int[][] key){
        int[][] result= new int[m][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                result[i][j] = key[j][m-1-i];
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception{
        int[][] key ={{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};

        System.out.println(solution(key, lock));
    }



}
