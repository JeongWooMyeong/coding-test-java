package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 비숍4 {

    static int N;
    static int[][] board;
    static List<int[]> black;
    static List<int[]> white;
    static int blackMax;
    static int whiteMax;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        black = new ArrayList<>();
        white = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) {
                    if ((i + j) % 2 == 0) {
                        black.add(new int[]{i, j});
                    } else {
                        white.add(new int[]{i, j});
                    }
                }

            }
        }

        blackMax = Integer.MIN_VALUE;
        whiteMax = Integer.MIN_VALUE;

        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

        dfs(0,0,black, true);

        Arrays.fill(diag1, false);
        Arrays.fill(diag2, false);

        dfs(0,0,white, false);

        System.out.println(whiteMax + blackMax);

    }

    static void dfs(int idx, int count, List<int[]> list, boolean isBlack){
        if(idx == list.size()){

            if(isBlack){
                blackMax = Math.max(blackMax, count);
            }else{
                whiteMax = Math.max(whiteMax, count);
            }
            return;
        }

        int[] cur = list.get(idx);
        int r = cur[0];
        int c = cur[1];

        dfs(idx+1, count, list, isBlack);


        if(!diag1[r+c] && !diag2[r-c+N-1]){
            diag1[r+c] = true;
            diag2[r-c+N-1] = true;
            dfs(idx+1, count+1, list, isBlack);
            diag1[r+c] = false;
            diag2[r-c+N-1] = false;
        }

    }

}
