package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
짰는데 인터넷 안되서 확인 필요
 */

public class 자물쇠와열쇠 {
    static int[][] board;

    public static boolean solution(int[][] key, int[][] lock){
        int n = lock.length;
        int m = key.length;
        //lock을 가운데다가 넣기 위한 보드 확장
        board = new int[3*n][3*n];

        //1. lock을 보드 가운데다가 넣기
        for(int i=n;i<2 * n;i++){
            for(int j=n;j<2 * n;j++){
                board[i][j] = lock[i%n][j%n];
            }
        }

        //2. key 회전하면서 key를 보드에 넣은 후 board가 전체 1이 되는지 확인
        for(int r=0;r<4;r++){
            key = rotate(key);

            for(int x=0;x<2*n;x++){
                for(int y=0;y<2*n;y++){
                    //board에 key 대입
                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] += key[i][j];

                        }
                    }

                    if(check(board, n)){
                        return true;
                    }

                    //아니라면 원상복구
                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] -= key[i][j];
                        }
                    }

                }
            }

        }

        //3. 못찾으면 return false

        return false;


    }
    //keye 배열 회전
    static int[][] rotate(int[][] key){
        int n = key.length;
        int[][] temp = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = key[j][n-1-i];
            }
        }

        return temp;

    }

    static boolean check(int[][] board, int n){
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
