package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 자물쇠와열쇠2 {
        //열쇠회전 (90도)
        static int[][] rotate(int[][] key){
            int M = key.length;
            int[][] rotated = new int[M][M];
            for(int i=0;i<M;i++){
                for(int j=0;j<M;j++){
                    rotated[j][M- 1 - i] = key[i][j];
                }
            }
            return rotated;
        }

        //중앙 lock 부분만 검사
        static boolean checkCenter(int[][] expandedLock, int N){
            for(int i=N;i<N*2;i++){
                for(int j=N;j<N*2;j++){
                    if(expandedLock[i][j] != 1) return false;
                }
            }
            return true;
        }

        public static boolean solution(int[][] key, int[][] lock){
            int N = lock.length;
            int M = key.length;

            //확장된 자물쇠 생성 (3배 크기)
            int[][] expandedLock = new int[N*3][N*3];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    expandedLock[i+N][j+N] = lock[i][j];    //중앙에 배치
                }
            }

            //4번 회전
            for(int r=0;r<4;r++){
                key = rotate(key);
                for(int i=0;i<=N*2;i++){
                    for(int j=0;j<=N*2;j++){
                        //key 올려놓기
                        for(int x=0;x<M;x++){
                            for(int y=0;y<M;y++){
                                expandedLock[i+x][j+y] += key[x][y];
                            }
                        }

                        //중앙 lock 확인
                        if(checkCenter(expandedLock, N)) return true;

                        //원상복구
                        for(int x=0;x<M;x++){
                            for(int y=0;y<M;y++){
                                expandedLock[i+x][j+y] -= key[x][y];
                            }
                        }
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) throws Exception{
            int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
            int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};

            System.out.println(solution(key, lock));
        }
}
