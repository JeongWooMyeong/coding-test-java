package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 비숍 {

    static int N;
    static int[][] board;

    static boolean[] diag1;
    static boolean[] diag2;

    static int[] answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = new int[2];

        diag1 = new boolean[2*N+1];
        diag2 = new boolean[2*N+1];
        board = new int[N][N];

        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,0,0);

        dfs(0,0,0);

        System.out.println(answer[0] + answer[1]);


    }

    static void dfs(int color, int sum, int count){
        if(sum >= 2 * N -1){
            answer[color] = Math.max(answer[color], count);

            return;
        }

        if(sum % 2 != color){
            dfs(color, sum+1, count);
            return;
        }

        dfs(color, sum+2, count);

        for(int r=0;r<N;r++){
            int c = sum - r;

            if(c < 0 || c >= N) continue;

            if(board[r][c] == 0) continue;

            int d1 = r - c + N;
            int d2 = r + c;

            if(diag1[d1] || diag2[d2]) continue;

            diag1[d1] = true;
            diag2[d2] = true;

            dfs(color, sum + 2, count + 1);

            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

}
