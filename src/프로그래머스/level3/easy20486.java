package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class easy20486 {

    static int N;
    static int[][] arr;
    static boolean[] merged;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        answer = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,arr);

        System.out.println(answer);

    }

    static void dfs(int depth, int[][] board){
        if(depth == 5){
            answer = Math.max(answer, getMax(board));
            return;
        }

        for(int dir=0;dir<4;dir++){
            //int[][] next = board.clone();
            int[][] next = copyBoard(board);

            move(next, dir);

            dfs(depth+1, next);

        }
    }

    static void move(int[][] board, int dir){

        if(dir == 0){
            for(int c=0;c<N;c++){
                merged = new boolean[N];
                for(int r=1;r<N;r++){
                    if(board[r][c] == 0) continue;

                    int nr = r;

                    while(nr > 0 && board[nr-1][c] == 0){
                        board[nr-1][c] = board[nr][c];
                        board[nr][c] = 0;
                        nr--;
                    }

                    if(nr > 0 && board[nr-1][c] == board[nr][c] && !merged[nr-1]){
                        board[nr-1][c] *= 2;
                        board[nr][c] = 0;
                        merged[nr-1] = true;
                    }
                }
            }
        } else if(dir == 1){
            for(int c=0;c<N;c++){
                merged = new boolean[N];
                for(int r=N-2;r>=0;r--){
                    if(board[r][c] == 0) continue;

                    int nr = r;

                    while(nr < N-1 && board[nr+1][c] == 0){
                        board[nr+1][c] = board[nr][c];
                        board[nr][c] = 0;
                        nr++;
                    }

                    if(nr < N-1 && board[nr+1][c] == board[nr][c] && !merged[nr+1]){
                        board[nr+1][c] *= 2;
                        board[nr][c] = 0;

                        merged[nr+1] = true;
                    }

                }
            }
        }else if(dir == 2){
            for(int r=0;r<N;r++){
                merged = new boolean[N];
                for(int c=1;c<N;c++){
                    if(board[r][c] == 0) continue;

                    int nc = c - 1;

                    while(nc > 0 && board[r][nc-1] == 0){
                        board[r][nc-1] = board[r][nc];
                        board[r][nc] = 0;
                        nc--;
                    }

                    if(nc > 0 && board[r][nc-1] == board[r][nc] && !merged[nc-1]){
                        board[r][nc-1] *= 2;
                        board[r][nc] = 0;

                        merged[nc-1] = true;
                    }

                }
            }
        }else if(dir == 3){
            for(int r=0;r<N;r++){
                merged = new boolean[N];
                for(int c=N-2;c>=0;c--){
                    if(board[r][c] == 0) continue;

                    int nc = c + 1;

                    while(nc < N-1 && board[r][nc+1] == 0){
                        board[r][nc+1] = board[r][nc];
                        board[r][nc] = 0;
                        nc++;
                    }

                    if(nc < N-1 && board[r][nc+1] == board[r][nc] && !merged[nc+1]){
                        board[r][nc+1] *= 2;
                        board[r][nc] = 0;
                        merged[nc+1] = true;
                    }

                }
            }
        }

    }

    static int[][] copyBoard(int[][] board){
        int[][] result = new int[N][N];

        for(int i=0;i<N;i++){
            result[i] = board[i].clone();
        }

        return result;
    }

    static int getMax(int[][] board){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                max = Math.max(max, board[i][j]);
            }
        }

        return max;
    }



}
