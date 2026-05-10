package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 자물쇠와열쇠2 {
    static int[][] board;

    public static boolean solution(int[][] key, int[][] lock){
        int n = lock.length;
        int m = key.length;
        board = new int[3*n][3*n];

        //1. lock 가운데에 넣기
        for(int i=n;i<2 * n;i++){
            for(int j=n;j<2 * n;j++){
                board[i][j] = lock[i%n][j%n];
            }
        }

        //2. 한칸씩 이동하면서 key와 lock 계산 2*n-1까지 계산
        //그 이후에는 범위를 넘어가므로 할 필요 없음
        for(int r=0;r<4;r++) {
            key = rotate(key, m);

            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    //키 값 대입
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            board[x + i][y + j] += key[x][y];
                        }
                    }

                    //lock 전체 1로 들어갔는지 확인
                    if (match(board, n)) return true;


                    //대입한거 다시 복구 (아니라는 이야기이므로)
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            board[x + i][y + j] -= key[x][y];
                        }
                    }

                }
            }
        }

        return false;
    }

    static int[][] rotate(int[][] key, int n){
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j] = key[j][n-1-i];
            }
        }

        return result;
    }

    static boolean match(int[][] lock, int n){
        for(int i=n;i<2*n;i++){
            for(int j=n;j<2*n;j++){
                if(lock[i][j] != 1) return false;
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
