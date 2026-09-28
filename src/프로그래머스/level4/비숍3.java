package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 비숍3 {

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
        blackMax = Integer.MIN_VALUE;
        whiteMax = Integer.MIN_VALUE;

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

        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

        dfs(black, 0, 0, true);

        Arrays.fill(diag1, false);
        Arrays.fill(diag2, false);

        dfs(white, 0, 0, false);

        System.out.println(blackMax + whiteMax);
    }

    static void dfs(List<int[]> list, int idx, int count, boolean isBlack){
        if(idx == list.size()){
            if(isBlack){
                blackMax = Math.max(blackMax, count);
            }else{
                whiteMax = Math.max(whiteMax, count);
            }
            return;
        }

        //놓지 않는경우
        dfs(list, idx+1, count, isBlack);

        int r = list.get(idx)[0];
        int c = list.get(idx)[1];

        if(!diag1[r+c] && !diag2[r-c+N-1]){
            diag1[r+c] = true;
            diag2[r-c+N-1] = true;
            dfs(list, idx+1, count+1, isBlack);
            diag1[r+c] = false;
            diag2[r-c+N-1] = false;
        }

    }

}
