package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 자물쇠와열쇠3 {

    static int[][] board;

    public static boolean solution(int[][] key, int[][] lock){
        int n = lock.length;
        int m = key.length;

        board = new int[3*n][3*n];
        //1. lock 가운데에 채우기
        for(int i=n;i<2*n;i++){
            for(int j=n;j<2*n;j++){
                board[i][j] = lock[i%n][j%n];
            }
        }

        //2. key 회전, lock, key 매칭
        // 2n-1 까지 (lock의 범위까지만 해주면 될듯)
        // 이후에는 매칭이 안됌
        for(int r=0;r<4;r++){
            key = rotate(key, m);
            for(int x=0;x<2*n;x++){
                for(int y=0;y<2*n;y++){
                    //lock에 key 대입 누적합
                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] += key[i][j];
                        }
                    }

                    //매칭한후 board 확인
                    if(match(board, n)) return true;

                    //아니라면 key 대입 누적 다시 복구
                    for(int i=0;i<m;i++){
                        for(int j=0;j<m;j++){
                            board[x+i][y+j] -= key[i][j];
                        }
                    }

                }
            }

        }

        //못찾으면 return false

        return false;
    }

    //회전
    static int[][] rotate(int[][] key, int n){
        int[][] result = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j] = key[j][n-1-i];
            }
        }

        return result;
    }

    //lock, key 조합후 확인
    static boolean match(int[][] board, int n){
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
