package 삼성SW역량테스트.골드.level1;

import java.io.*;
import java.util.*;

public class Easy2048 {
    static int N;
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, board);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] curBoard){
        if(depth == 5){
            max = Math.max(max, getMax(curBoard));
            return;
        }
        for(int dir=0;dir<4;dir++){
            int[][] newBoard = move(curBoard, dir);
            dfs(depth+1, newBoard);
        }
    }

    //보드 이동
    static int[][] move(int[][] b, int dir){
        int[][] newBoard = new int[N][N];
        for(int i=0;i<N;i++) newBoard[i] = b[i].clone();

        //방향별 처리
        switch(dir){
            case 0:
                for(int j=0;j<N;j++){
                    int[] line = new int[N];
                    int idx = 0;
                    int prev = 0;
                    for(int i=0;i<N;i++){
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            if(prev == newBoard[i][j]){
                                line[idx++] = prev*2;
                                prev = 0;
                            }else{
                                line[idx++] = prev;
                                prev = newBoard[i][j];
                            }
                        }
                    }
                    //남은 prev 처리
                    if(prev != 0) line[idx] = prev;
                    for(int i=0;i<N;i++) newBoard[i][j] = line[i];
                }
                break;
            case 1: //아래
                for(int j=0;j<N;j++){
                    int[] line = new int[N];
                    int idx = N-1;
                    int prev = 0;
                    for(int i=N-1;i>=0;i--){
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            if(prev == newBoard[i][j]){
                                line[idx--] = prev*2;
                                prev = 0;
                            }else{
                                line[idx--] = prev;
                                prev = newBoard[i][j];
                            }
                        }
                    }
                    if(prev != 0) line[idx] = prev;
                    for(int i=0;i<N;i++) newBoard[i][j] = line[i];
                }
                break;
            case 2: //왼쪽
                for(int i=0;i<N;i++){
                    int[] line = new int[N];
                    int idx = 0;
                    int prev = 0;
                    for(int j=0;j<N;j++){
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            if(prev == newBoard[i][j]) {
                                line[idx++] = prev * 2;
                                prev = 0;
                            }else{
                                line[idx++] = prev;
                                prev = newBoard[i][j];
                            }

                        }
                    }
                    if(prev != 0) line[idx] = prev;
                    for(int j=0;j<N;j++) newBoard[i][j] = line[j];
                }
                break;
            case 3: //오른쪽
                for(int i=0;i<N;i++){
                    int[] line = new int[N];
                    int idx = N-1;
                    int prev = 0;
                    for(int j=N-1;j>=0;j--){
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            if(prev == newBoard[i][j]){
                                line[idx--] = prev*2;
                                prev = 0;
                            }else{
                                line[idx--] = prev;
                                prev = newBoard[i][j];
                            }
                        }
                    }
                    if(prev != 0) line[idx] = prev;
                    for(int j=0;j<N;j++) newBoard[i][j] = line[j];
                }
                break;
        }
        return newBoard;
    }

    //현재 보드에서 최대값 찾기
    static int getMax(int[][] b){
        int val = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                val = Math.max(val, b[i][j]);
            }
        }
        return val;
    }

}
